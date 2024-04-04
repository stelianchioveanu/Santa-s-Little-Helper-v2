package database;

import action.Action;
import action.Round;
import annual.AnnualChange;
import children.Child;
import enums.Cities;
import files.reader.Input;
import files.writer.ChildrenListWriter;
import files.writer.ChildrenWriter;
import files.writer.Writer;
import files.writer.AnnualChildrenWriter;
import gift.Gift;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

public final class Database {

    private Integer numberOfYears;
    private Double santaBudget;
    private final ArrayList<Child> childrenList = new ArrayList<>();
    private final ArrayList<Gift> santaGiftsList = new ArrayList<>();
    private final ArrayList<AnnualChange> annualChangeList = new ArrayList<>();
    private final HashSet<Cities> citiesHashSet = new LinkedHashSet<>();

    private static Database instance = null;

    private Database() {
    }

    /**
     * If the Repository instance is null, create a new one
     *
     * @return Instance of Repository class
     */
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    private void populateDatabase(final Input input) {
        this.numberOfYears = input.getNumberOfYears();
        this.santaBudget = input.getSantaBudget();

        Action action = new Action();
        action.addNewChildren(this, input.getInitialData().getChildren());

        this.santaGiftsList.addAll(input.getInitialData().getSantaGiftsList());
        this.annualChangeList.addAll(input.getAnnualChanges());
    }

    private void clearDatabase() {
        this.numberOfYears = 0;
        this.santaBudget = 0.0;
        this.childrenList.clear();
        this.santaGiftsList.clear();
        this.annualChangeList.clear();
    }

    /**
     * This is the entry point of the implementation
     * Firstly populate the repository, then add the results
     * of the actions to the output file and finally release the repository.
     *
     * @param fileWriter  Write in output file
     * @param input       Contain the inputs
     */
    public void entryPoint(final Input input, final Writer fileWriter) {
        AnnualChildrenWriter writerOutput = new AnnualChildrenWriter();

        this.populateDatabase(input);

        for (int i = 0; i <= this.numberOfYears; i++) {
            Round round = new Round(i);
            round.currentRound(this);

            ChildrenListWriter childrenWriter = new ChildrenListWriter();

            for (Child child : this.childrenList) {
                childrenWriter.getChildren().add(new ChildrenWriter(child.getId(),
                        child.getLastName(), child.getFirstName(), child.getCity(),
                        child.getAge(), child.getGiftsPreferences(), child.getAverageScore(),
                        child.getNiceScoreHistory(), child.getAssignedBudget(),
                        child.getReceivedGifts()));
            }

            writerOutput.getAnnualChildren().add(childrenWriter);
        }

        fileWriter.writeFile(writerOutput);
        this.clearDatabase();
    }

    public Integer getNumberOfYears() {
        return numberOfYears;
    }

    public Double getSantaBudget() {
        return santaBudget;
    }

    public ArrayList<Child> getChildrenList() {
        return childrenList;
    }

    public ArrayList<Gift> getSantaGiftsList() {
        return santaGiftsList;
    }

    public ArrayList<AnnualChange> getAnnualChangeList() {
        return annualChangeList;
    }

    public HashSet<Cities> getCitiesHashSet() {
        return citiesHashSet;
    }

    public void setNumberOfYears(final Integer numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public void setSantaBudget(final Double santaBudget) {
        this.santaBudget = santaBudget;
    }
}
