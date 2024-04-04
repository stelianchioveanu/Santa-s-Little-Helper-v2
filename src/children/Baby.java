package children;

public final class Baby extends Child {

    public Baby(final ChildBuilder child) {
        super((child));
    }

    @Override
    public String getChildType() {
        return "Baby";
    }
}
