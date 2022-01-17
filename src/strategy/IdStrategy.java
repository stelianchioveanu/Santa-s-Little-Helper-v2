package strategy;

import children.Child;
import database.Database;

import java.util.ArrayList;

public final class IdStrategy implements Strategy {
    @Override
    public ArrayList<Child> childrenListSortByStrategy(final Database database) {
        return database.getChildrenList();
    }
}
