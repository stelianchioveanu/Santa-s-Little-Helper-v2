package children;

import enums.Category;
import enums.Cities;
import files.reader.ChildLoader;
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

    public Child(final ChildLoader childLoader) {
        this.id = childLoader.getId();
        this.lastName = childLoader.getLastName();
        this.firstName = childLoader.getFirstName();
        this.age = childLoader.getAge();
        this.city = childLoader.getCity();
        this.giftsPreferences = new ArrayList<>();
        this.giftsPreferences.addAll(childLoader.getGiftsPreferences());
        this.averageScore = 0.0;
        this.niceScoreHistory = new ArrayList<>();
        this.niceScoreHistory.add(childLoader.getNiceScore());
        this.assignedBudget = 0.0;
        this.receivedGifts = new ArrayList<>();
    }

    public Child(final Child child) {
        this.id = child.id;
        this.lastName = child.lastName;
        this.firstName = child.firstName;
        this.city = child.city;
        this.age = child.age;
        this.giftsPreferences = child.giftsPreferences;
        this.averageScore = child.averageScore;
        this.niceScoreHistory = child.niceScoreHistory;
        this.assignedBudget = child.assignedBudget;
        this.receivedGifts = child.receivedGifts;
    }

    /**
     * This method is used to get the gifts preferences.
     */
    public ArrayList<Category> getGiftsPreferences() {
        return giftsPreferences;
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
