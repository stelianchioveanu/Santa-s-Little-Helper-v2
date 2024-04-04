package children;

public final class Kid extends Child {

    public Kid(final ChildBuilder child) {
        super((child));
    }

    @Override
    public String getChildType() {
        return "Kid";
    }
}
