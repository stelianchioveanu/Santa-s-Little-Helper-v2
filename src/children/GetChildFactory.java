package children;

import common.Constants;

public final class GetChildFactory {

    /**
     * This method create a child by his age.
     *
     * @param child child builder
     * @return new child
     */
    public Child getChildByChildBuilder(final ChildBuilder child) {
        Child newChild = null;
        Integer age = child.getAge();
        if (age < Constants.KID) {
            newChild = new Baby(child);
        } else if (age < Constants.TEEN) {
            newChild = new Kid(child);
        } else if (age <= Constants.YOUNG_ADULT) {
            newChild = new Teen(child);
        }
        return newChild;
    }
}
