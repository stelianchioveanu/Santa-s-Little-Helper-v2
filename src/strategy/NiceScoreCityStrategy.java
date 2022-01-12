package strategy;

import children.Child;
import database.Database;
import enums.Cities;

import java.util.*;

public class NiceScoreCityStrategy implements Strategy {
    @Override
    public ArrayList<Child> childrenListSortByStrategy(Database database) {
        HashMap<Cities, Double> citiesHashMap = new LinkedHashMap<>();
        ArrayList<Child> childrenListSorted = new ArrayList<>();

        for (Cities city : database.getCitiesHashSet()) {
            Double niceScoreCity = 0.0;
            Double counter = 0.0;
            for (Child child : database.getChildrenList()) {
                if (child.getCity().equals(city)) {
                    niceScoreCity += child.getAverageScore();
                    counter++;
                }
            }
            citiesHashMap.put(city, niceScoreCity / counter);
        }

        ArrayList<Map.Entry<Cities, Double>> citiesArrayListSorted = new ArrayList<>(citiesHashMap.entrySet());
        citiesArrayListSorted.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey().getValue().compareTo(o2.getKey().getValue());
            }
            return o2.getValue().compareTo(o1.getValue());
        });

        for (Map.Entry<Cities, Double> entry : citiesArrayListSorted) {
            for (Child child : database.getChildrenList()) {
                if (child.getCity().equals(entry.getKey())) {
                    childrenListSorted.add(child);
                }
            }
        }

        return childrenListSorted;
    }
}
