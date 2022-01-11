package files.reader;

import annual.AnnualChange;

import java.util.ArrayList;
import java.util.List;

public final class Input {
    private final Integer numberOfYears;
    private final Double santaBudget;
    private final InitialDataLoader initialData;
    private final List<AnnualChange> annualChanges;

    public Input() {
        this.numberOfYears = 0;
        this.santaBudget = 0.0;
        this.initialData = new InitialDataLoader();
        this.annualChanges = new ArrayList<>();
    }

    public Integer getNumberOfYears() {
        return numberOfYears;
    }

    public Double getSantaBudget() {
        return santaBudget;
    }

    public InitialDataLoader getInitialData() {
        return initialData;
    }

    public List<AnnualChange> getAnnualChanges() {
        return annualChanges;
    }
}
