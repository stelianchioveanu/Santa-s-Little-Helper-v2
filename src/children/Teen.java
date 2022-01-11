package children;

import files.reader.ChildLoader;

public final class Teen extends Child {

    public Teen(final ChildLoader childLoader) {
        super(childLoader);
    }

    public Teen(final Child child) {
        super((child));
    }

    @Override
    public String getChildType() {
        return "Teen";
    }
}
