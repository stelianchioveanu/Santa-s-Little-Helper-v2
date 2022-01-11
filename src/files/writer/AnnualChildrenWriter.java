package files.writer;

import java.util.ArrayList;

public final class AnnualChildrenWriter {
    private final ArrayList<ChildrenListWriter> annualChildren;

    public AnnualChildrenWriter() {
        this.annualChildren = new ArrayList<>();
    }

    public ArrayList<ChildrenListWriter> getAnnualChildren() {
        return annualChildren;
    }
}
