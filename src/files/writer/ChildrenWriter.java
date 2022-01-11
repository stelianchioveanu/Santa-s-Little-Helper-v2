package files.writer;

import enums.Category;
import enums.Cities;
import gift.Gift;

import java.util.ArrayList;

public final class ChildrenWriter {
    private final Integer id;
    private final String lastName;
    private final String firstName;
    private final Cities city;
    private final Integer age;
    private final ArrayList<Category> giftsPreferences;
    private final Double averageScore;
    private final ArrayList<Double> niceScoreHistory;
    private final Double assignedBudget;
    private final ArrayList<GiftWriter> receivedGifts;

    public ChildrenWriter(final Integer id, final String lastName,
                 final String firstName, final Cities city,
                 final Integer age, final ArrayList<Category> giftsPreferences,
                 final Double averageScore, final ArrayList<Double> niceScoreHistory,
                 final Double assignedBudget, final ArrayList<Gift> receivedGifts) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.city = city;
        this.age = age;
        this.giftsPreferences = new ArrayList<>();
        this.giftsPreferences.addAll(giftsPreferences);
        this.averageScore = averageScore;
        this.niceScoreHistory = new ArrayList<>();
        this.niceScoreHistory.addAll(niceScoreHistory);
        this.assignedBudget = assignedBudget;
        this.receivedGifts = new ArrayList<>();
        for (Gift gift : receivedGifts){
            this.receivedGifts.add(new GiftWriter(gift.getProductName(),
                    gift.getPrice(), gift.getCategory()));
        }
    }

    public ArrayList<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public Double getAssignedBudget() {
        return assignedBudget;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getAge() {
        return age;
    }

    public Cities getCity() {
        return city;
    }

    public Integer getId() {
        return id;
    }

    public ArrayList<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public ArrayList<GiftWriter> getReceivedGifts() {
        return receivedGifts;
    }
}
