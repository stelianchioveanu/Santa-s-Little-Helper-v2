package children;

import common.Constants;
import files.reader.ChildLoader;

public final class GetChildFactory {

    /**
     * This method is used to create a child by his age.
     *
     * @param age age
     * @param childLoader child loader
     */
    public Child getChildByChildLoader(final Integer age, final ChildLoader childLoader) {
        Child newChild = null;
        if (age < Constants.KID) {
            newChild = new Baby(childLoader);
        } else if (age < Constants.TEEN) {
            newChild = new Kid(childLoader);
        } else if (age <= Constants.YOUNG_ADULT) {
            newChild = new Teen(childLoader);
        }
        return newChild;
    }

    /**
     * This method is used to create a child by his age.
     *
     * @param age age
     * @param child child
     */
    public Child getChildByChild(final Integer age, final Child child) {
        Child newChild = null;
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
