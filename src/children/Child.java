package children;

import enums.Category;
import enums.Cities;
import enums.ElvesType;
import gift.Gift;

import java.util.ArrayList;

public abstract class Child {
    protected final Integer id;
    protected final String lastName;
    protected final String firstName;
    protected final Cities city;
    protected Integer age;
    protected final ArrayList<Category> giftsPreferences;
    protected Double averageScore;
    protected final ArrayList<Double> niceScoreHistory;
    protected Double assignedBudget;
    protected final ArrayList<Gift> receivedGifts;
    protected ElvesType elf;
    protected final Double niceScoreBonus;

    public Child(final ChildBuilder child) {
        this.id = child.getId();
        this.lastName = child.getLastName();
        this.firstName = child.getFirstName();
        this.city = child.getCity();
        this.age = child.getAge();
        this.giftsPreferences = child.getGiftsPreferences();
        this.averageScore = child.getAverageScore();
        this.niceScoreHistory = child.getNiceScoreHistory();
        this.assignedBudget = child.getAssignedBudget();
        this.receivedGifts = child.getReceivedGifts();
        this.elf = child.getElf();
        this.niceScoreBonus = child.getNiceScoreBonus();
    }

    /**
     * This method is used to get the gifts preferences.
     */
    public ArrayList<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    /**
     * This method is used to get the nice score bonus.
     */
    public Double getNiceScoreBonus() {
        return niceScoreBonus;
    }

    /**
     * This method is used to get the assigned budget.
     */
    public Double getAssignedBudget() {
        return assignedBudget;
    }

    /**
     * This method is used to get the last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This method is used to get the first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * This method is used to get the age.
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method is used to get the city.
     */
    public Cities getCity() {
        return city;
    }

    /**
     * This method is used to get the id.
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method is used to get the nice score history.
     */
    public ArrayList<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    /**
     * This method is used to get the average score.
     */
    public Double getAverageScore() {
        return averageScore;
    }

    /**
     * This method is used to get the received gifts.
     */
    public ArrayList<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    /**
     * This method is used to get the elf type.
     */
    public ElvesType getElf() {
        return elf;
    }

    /**
     * This method is used to set the elf type.
     */
    public void setElf(final ElvesType elf) {
        this.elf = elf;
    }

    /**
     * This method is used to set the average score.
     */
    public void setAverageScore(final Double averageScore) {
        this.averageScore = averageScore;
    }

    /**
     * This method is used to set the assigned budget.
     */
    public void setAssignedBudget(final Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    /**
     * This method is used to set the age.
     */
    public void setAge(final Integer age) {
        this.age = age;
    }

    /**
     * This method is used to get the child's type.
     */
    public abstract String getChildType();

}
