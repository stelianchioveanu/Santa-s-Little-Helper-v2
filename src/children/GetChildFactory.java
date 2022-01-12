package children;

import common.Constants;
import files.reader.ChildLoader;

public final class GetChildFactory {

    /**
     * This method is used to create a child by his age.
     *
     * @param child child
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
