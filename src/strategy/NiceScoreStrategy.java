package strategy;


import children.Child;
import database.Database;

import java.util.ArrayList;

public class NiceScoreStrategy implements Strategy {
    @Override
    public ArrayList<Child> childrenListSortByStrategy(Database database) {
        ArrayList<Child> sortedArrayChildren = new ArrayList<>(database.getChildrenList());
        sortedArrayChildren.sort((o1, o2) -> {
            if (o1.getAverageScore().equals(o2.getAverageScore())) {
                return o1.getId().compareTo(o2.getId());
            }
            return o2.getAverageScore().compareTo(o1.getAverageScore());
        });
        return sortedArrayChildren;
    }
}
