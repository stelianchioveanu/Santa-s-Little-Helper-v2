package strategy;

import children.Child;
import database.Database;
import enums.Cities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class NiceScoreCityStrategy implements Strategy {
    /**
     * This method is used to create a list of children sorted by nice score strategy.
     *
     * @param database database
     * @return children arraylist
     */
    @Override
    public ArrayList<Child> childrenListSortByStrategy(final Database database) {
        HashMap<Cities, Double> citiesHashMap = new HashMap<>();
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

        ArrayList<Map.Entry<Cities, Double>> citiesArrayListSorted =
                new ArrayList<>(citiesHashMap.entrySet());
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
