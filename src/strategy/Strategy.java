package strategy;

import children.Child;
import database.Database;

import java.util.ArrayList;

public interface Strategy {
    /**
     * This method returns a list of children sorted by strategy.
     */
    ArrayList<Child> childrenListSortByStrategy(Database database);
}
