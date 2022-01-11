package files.writer;

import java.util.ArrayList;

public final class ChildrenListWriter {
    private final ArrayList<ChildrenWriter> children;

    public ChildrenListWriter() {
        this.children = new ArrayList<>();
    }

    public ArrayList<ChildrenWriter> getChildren() {
        return children;
    }
}
