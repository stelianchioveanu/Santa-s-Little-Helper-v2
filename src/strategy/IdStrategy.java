package strategy;

import children.Child;
import database.Database;

import java.util.ArrayList;

public final class IdStrategy implements Strategy {
    /**
     * This method is used to create a list of children sorted by nice score strategy.
     * Database children list is already sorted.
     *
     * @param database database
     * @return children arraylist
     */
    @Override
    public ArrayList<Child> childrenListSortByStrategy(final Database database) {
        return database.getChildrenList();
    }
}
