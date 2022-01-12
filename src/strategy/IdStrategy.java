package strategy;


import action.Action;
import children.Child;
import database.Database;

import java.util.ArrayList;

public class IdStrategy implements Strategy{
    @Override
    public ArrayList<Child> childrenListSortByStrategy(Database database) {
        return database.getChildrenList();
    }
}
