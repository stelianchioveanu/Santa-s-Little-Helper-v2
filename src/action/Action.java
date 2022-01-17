package action;

import annual.AnnualChange;
import children.ChildBuilder;
import children.Child;
import common.Constants;
import database.Database;
import enums.Category;
import enums.ElvesType;
import files.reader.ChildLoader;
import files.reader.ChildUpdateLoader;
import gift.Gift;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Collections;

public final class Action {

    /**
     * This method add new children in database list using the child builder.
     *
     * @param database             database
     * @param childLoaderArrayList input list with children
     */
    public void addNewChildren(final Database database,
                               final List<ChildLoader> childLoaderArrayList) {
        for (ChildLoader childLoader : childLoaderArrayList) {

            ChildBuilder childBuilder = new ChildBuilder(childLoader.getId(), childLoader.getLastName(),
                    childLoader.getFirstName(), childLoader.getCity(), childLoader.getAge(),
                    childLoader.getElf(), childLoader.getNiceScoreBonus(), childLoader.getGiftsPreferences());

            if (childBuilder.build() != null) {
                database.getChildrenList().add(childBuilder
                        .niceScore(childLoader.getNiceScore())
                        .build());

                database.getCitiesHashSet().add(childLoader.getCity());
            }
        }
    }

    /**
     * This method is used to calculate the assigned budget.
     *
     * @param child current child
     * @param budgetUnit budget unit
     */
    public Double assignedBudgetCalculation(final Child child, final Double budgetUnit) {
        double assignedBudget = child.getAverageScore() * budgetUnit;

        if (child.getElf().equals(ElvesType.BLACK)) {
            assignedBudget -= assignedBudget * Constants.ELF_DISCOUNT / Constants.PERCENT;

        } else if (child.getElf().equals(ElvesType.PINK)) {
            assignedBudget += assignedBudget * Constants.ELF_DISCOUNT / Constants.PERCENT;

        }
        return assignedBudget;
    }

    public void setChildrenAssignedBudget(final Database database, final Double budgetUnit) {
        for (Child child : database.getChildrenList()) {
            child.setAssignedBudget(assignedBudgetCalculation(child, budgetUnit));
        }
    }


    /**
     * This method is used to distribute gifts to children.
     */
    public void distributionGifts(final ArrayList<Child> childrenList,
                                  final ArrayList<Gift> santaGifts) {
        for (Child child : childrenList) {
            Double copyBudget = child.getAssignedBudget();

            for (Category category : child.getGiftsPreferences()) {

                for (Gift gift : santaGifts) {

                    if (category.equals(gift.getCategory())) {

                        if (gift.getQuantity() != 0) {

                            if (copyBudget >= gift.getPrice()) {
                                child.getReceivedGifts().add(gift);
                                copyBudget -= gift.getPrice();
                                gift.setQuantity(gift.getQuantity() - 1);
                                break;
                            }
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
            Child currentChild = database.getChildrenList().get(i);

            currentChild.setAge(currentChild.getAge() + 1);
            currentChild.getReceivedGifts().clear();

            String childType = currentChild.getChildType();
            Integer age = currentChild.getAge();
            Child newChild;

            if (childType.equals(Constants.TEEN_STRING) && age > Constants.YOUNG_ADULT) {
                database.getChildrenList().remove(i);
                i--;
            } else {
                newChild = new ChildBuilder(currentChild.getId(), currentChild.getLastName(),currentChild.getFirstName(),
                        currentChild.getCity(),currentChild.getAge(), currentChild.getElf(), currentChild.getNiceScoreBonus(),
                        currentChild.getGiftsPreferences())
                        .niceScoreHistory(currentChild.getNiceScoreHistory())
                        .assignedBudget(currentChild.getAssignedBudget())
                        .receivedGifts(currentChild.getReceivedGifts())
                        .averageScore(currentChild.getAverageScore())
                        .build();
                database.getChildrenList().remove(i);
                database.getChildrenList().add(i, newChild);
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
        Double averageScore;

        for (Child child : database.getChildrenList()) {

            if (child.getChildType().equals(Constants.BABY_STRING)) {
                averageScore = Constants.BABY_SCORE;

            } else if (child.getChildType().equals(Constants.KID_STRING)) {
                Double niceScoreSum = child.getNiceScoreHistory().stream().
                        reduce(0.0, Double::sum);
                averageScore = niceScoreSum / child.getNiceScoreHistory().size();

            } else {
                double niceScoreSum = 0.0;
                for (int i = 0; i < child.getNiceScoreHistory().size(); i++) {
                    niceScoreSum += child.getNiceScoreHistory().get(i) * (i + 1);
                }
                averageScore = niceScoreSum
                        / ((child.getNiceScoreHistory().size()
                        * (child.getNiceScoreHistory().size() + 1)) / 2);

            }
            averageScore += averageScore * child.getNiceScoreBonus() / 100;
            if (averageScore > Constants.BABY_SCORE) {
                averageScore = Constants.BABY_SCORE;
            }
            child.setAverageScore(averageScore);
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
     * @param database            database
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

                    child.setElf(childUpdateLoader.getElf());

                    break;
                }
            }
        }
    }

    public void yellowElf(final Database database) {
        for (Child child : database.getChildrenList()) {

            if (child.getElf().equals(ElvesType.YELLOW)) {

                if (child.getReceivedGifts().size() == 0) {

                    for (Category category : child.getGiftsPreferences()) {
                        for (Gift gift : database.getSantaGiftsList()) {
                            if (category.equals(gift.getCategory())) {
                                if (gift.getQuantity() != 0) {
                                    child.getReceivedGifts().add(gift);
                                    gift.setQuantity(gift.getQuantity() - 1);
                                    return;
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}
