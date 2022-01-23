package children;

import enums.Category;
import enums.Cities;
import enums.ElvesType;
import gift.Gift;

import java.util.ArrayList;

public final class ChildBuilder {
    private final Integer id;
    private final String lastName;
    private final String firstName;
    private final Cities city;
    private final Integer age;
    private final ArrayList<Category> giftsPreferences = new ArrayList<>();
    private Double averageScore = 0.0;
    private ArrayList<Double> niceScoreHistory = new ArrayList<>();
    private Double assignedBudget = 0.0;
    private final ArrayList<Gift> receivedGifts = new ArrayList<>();
    private final ElvesType elf;
    private final Double niceScoreBonus;

    public ChildBuilder(final Integer id, final String lastName, final String firstName,
                        final Cities city, final Integer age, final ElvesType elf,
                        final Double niceScoreBonus, final ArrayList<Category> giftsPreferences) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.city = city;
        this.age = age;
        this.elf = elf;
        this.niceScoreBonus = niceScoreBonus;
        this.giftsPreferences.addAll(giftsPreferences);
    }

    /**
     * This method is used to set the average score.
     *
     */
    public ChildBuilder averageScore(final Double score) {
        this.averageScore = score;
        return this;
    }

    /**
     * This method is used to set nice score history.
     *
     */
    public ChildBuilder niceScoreHistory(final ArrayList<Double> scoreHistory) {
        this.niceScoreHistory = scoreHistory;
        return this;
    }

    /**
     * This method is used to set the assigned budget.
     *
     */
    public ChildBuilder assignedBudget(final Double budget) {
        this.assignedBudget = budget;
        return this;
    }

    /**
     * This method is used to set the received gifts.
     *
     */
    public ChildBuilder receivedGifts(final ArrayList<Gift> gifts) {
        this.receivedGifts.addAll(gifts);
        return this;
    }

    /**
     * This method is used to set the nice score.
     *
     */
    public ChildBuilder niceScore(final Double niceScore) {
        this.niceScoreHistory.add(niceScore);
        return this;
    }

    /**
     * This method is used to build the child.
     *
     */
    public Child build() {
        GetChildFactory childFactory = new GetChildFactory();
        return childFactory.getChildByChildBuilder(this);
    }

    public Integer getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Cities getCity() {
        return city;
    }

    public Integer getAge() {
        return age;
    }

    public ArrayList<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public ArrayList<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public Double getAssignedBudget() {
        return assignedBudget;
    }

    public ArrayList<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    public ElvesType getElf() {
        return elf;
    }

    public Double getNiceScoreBonus() {
        return niceScoreBonus;
    }
}
