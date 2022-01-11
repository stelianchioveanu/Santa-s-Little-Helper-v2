package action;

import annual.AnnualChange;
import children.GetChildFactory;
import children.Child;
import common.Constants;
import database.Database;
import enums.Category;
import files.reader.ChildLoader;
import files.reader.ChildUpdateLoader;
import gift.Gift;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public final class Action {

    /**
     * This method add new children in database list using the child factory.
     *
     * @param database database
     * @param childLoaderArrayList input list with children
     */
    public void addNewChildren(final Database database,
                               final List<ChildLoader> childLoaderArrayList) {
        for (ChildLoader childLoader : childLoaderArrayList) {
            GetChildFactory childFactory = new GetChildFactory();

            if (childFactory.getChildByChildLoader(childLoader.getAge(), childLoader) != null) {
                database.getChildrenList().add(
                        childFactory.getChildByChildLoader(childLoader.getAge(), childLoader));
            }
        }
    }

    /**
     * This method is used to distribute gifts to children.
     *
     * @param database database
     * @param budgetUnit  budget unit
     */
    public void distributionGifts(final Database database, final Double budgetUnit) {
        for (Child child : database.getChildrenList()) {

            child.setAssignedBudget(child.getAverageScore() * budgetUnit);
            Double copyBudget = child.getAssignedBudget();

            for (Category category : child.getGiftsPreferences()) {

                for (Gift gift : database.getSantaGiftsList()) {

                    if (category.equals(gift.getCategory())) {

                        if (copyBudget >= gift.getPrice()) {
                            child.getReceivedGifts().add(gift);
                            copyBudget -= gift.getPrice();
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     * This method is used to increase the age of children.
     * If a child becomes another type it will be deleted and a
     * new one will be added to the same position using the child factory.
     *
     * @param database database
     */
    public void increaseAge(final Database database) {
        for (int i = 0; i < database.getChildrenList().size(); i++) {
            database.getChildrenList().get(i).setAge(
                    database.getChildrenList().get(i).getAge() + 1);
            database.getChildrenList().get(i).getReceivedGifts().clear();

            String childType = database.getChildrenList().get(i).getChildType();
            Integer age = database.getChildrenList().get(i).getAge();
            Child newChild;
            GetChildFactory getChildFactory = new GetChildFactory();

            if (childType.equals(Constants.BABY_STRING) && age.equals(Constants.KID)) {
                newChild = getChildFactory.getChildByChild(age, database.getChildrenList().get(i));
                database.getChildrenList().remove(i);
                database.getChildrenList().add(i, newChild);
            } else if (childType.equals(Constants.KID_STRING) && age.equals(Constants.TEEN)) {
                newChild = getChildFactory.getChildByChild(age, database.getChildrenList().get(i));
                database.getChildrenList().remove(i);
                database.getChildrenList().add(i, newChild);
            } else if (childType.equals(Constants.TEEN_STRING) && age > Constants.YOUNG_ADULT) {
                database.getChildrenList().remove(i);
                i--;
            }
        }
    }

    /**
     * This method is used to calculate the budget unit and set the average score.
     *
     * @param database database
     */
    public Double budgetUnit(final Database database) {
        Double sumScores = 0.0;

        for (Child child : database.getChildrenList()) {

            if (child.getChildType().equals(Constants.BABY_STRING)) {
                child.setAverageScore(Constants.BABY_SCORE);

            } else if (child.getChildType().equals(Constants.KID_STRING)) {
                Double niceScoreSum = child.getNiceScoreHistory().stream().
                        reduce(0.0, Double::sum);
                child.setAverageScore(niceScoreSum / child.getNiceScoreHistory().size());

            } else {
                double niceScoreSum = 0.0;
                for (int i = 0; i < child.getNiceScoreHistory().size(); i++) {
                    niceScoreSum += child.getNiceScoreHistory().get(i) * (i + 1);
                }
                child.setAverageScore(niceScoreSum
                        / ((child.getNiceScoreHistory().size()
                        * (child.getNiceScoreHistory().size() + 1)) / 2));

            }
            sumScores += child.getAverageScore();
        }

        return database.getSantaBudget() / sumScores;
    }

    /**
     * This method is used to sort the gift list by price.
     *
     * @param database database
     */
    public void sortGifts(final Database database) {
        database.getSantaGiftsList().sort(Comparator.comparingDouble(Gift::getPrice));
    }

    /**
     * This method is used to update children's data.
     *
     * @param database database
     * @param currentAnnualChange annual changes
     */
    public void updateChild(final Database database, final AnnualChange currentAnnualChange) {
        for (ChildUpdateLoader childUpdateLoader : currentAnnualChange.getChildrenUpdates()) {

            for (Child child : database.getChildrenList()) {

                if (Objects.equals(child.getId(), childUpdateLoader.getId())) {
                    if (childUpdateLoader.getNiceScore() != null) {
                        child.getNiceScoreHistory().add(childUpdateLoader.getNiceScore());
                    }

                    Collections.reverse(childUpdateLoader.getGiftsPreferences());

                    for (Category category : childUpdateLoader.getGiftsPreferences()) {
                        child.getGiftsPreferences().remove(category);
                        child.getGiftsPreferences().add(0, category);
                    }

                    break;
                }
            }
        }
    }
}
