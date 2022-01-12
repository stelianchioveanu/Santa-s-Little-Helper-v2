package strategy;

import children.Child;
import database.Database;

import java.util.ArrayList;

public interface Strategy {
    ArrayList<Child> childrenListSortByStrategy(Database database);
}
