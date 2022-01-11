package children;

import files.reader.ChildLoader;

public final class Baby extends Child {

    public Baby(final ChildLoader childLoader) {
        super(childLoader);
    }

    public Baby(final Child child) {
        super((child));
    }

    @Override
    public String getChildType() {
        return "Baby";
    }
}
