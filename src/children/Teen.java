package children;

public final class Teen extends Child {

    public Teen(final ChildBuilder child) {
        super((child));
    }

    @Override
    public String getChildType() {
        return "Teen";
    }
}
