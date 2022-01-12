package children;

import enums.Category;
import enums.Cities;
import enums.ElvesType;
import gift.Gift;

import java.util.ArrayList;

public class ChildBuilder {
    private Integer id;
    private String lastName;
    private String firstName;
    private Cities city;
    private Integer age;
    private ArrayList<Category> giftsPreferences = new ArrayList<>();
    private Double averageScore = 0.0;
    private ArrayList<Double> niceScoreHistory = new ArrayList<>();
    private Double assignedBudget = 0.0;
    private ArrayList<Gift> receivedGifts = new ArrayList<>();
    private ElvesType elf;
    private Double niceScoreBonus;
    private Double niceScore;

    public ChildBuilder(Integer id, String lastName, String firstName,
                   Cities city, Integer age, ElvesType elf, Double niceScoreBonus, ArrayList<Category> giftsPreferences) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.city = city;
        this.age = age;
        this.elf = elf;
        this.niceScoreBonus = niceScoreBonus;
        this.giftsPreferences.addAll(giftsPreferences);
    }


    public ChildBuilder averageScore(Double averageScore) {
        this.averageScore = averageScore;
        return this;
    }

    public ChildBuilder niceScoreHistory(ArrayList<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
        return this;
    }

    public ChildBuilder assignedBudget(Double assignedBudget) {
        this.assignedBudget = assignedBudget;
        return this;
    }

    public ChildBuilder receivedGifts(ArrayList<Gift> receivedGifts) {
        this.receivedGifts.addAll(receivedGifts);
        return this;
    }

    public ChildBuilder niceScore(Double niceScore) {
        this.niceScoreHistory.add(niceScore);
        return this;
    }

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
