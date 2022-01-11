package children;

import files.reader.ChildLoader;

public final class Kid extends Child {

    public Kid(final ChildLoader childLoader) {
        super(childLoader);
    }

    public Kid(final Child child) {
        super((child));
    }

    @Override
    public String getChildType() {
        return "Kid";
    }
}
