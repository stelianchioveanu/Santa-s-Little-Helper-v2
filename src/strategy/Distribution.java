package strategy;

import action.Action;
import database.Database;

public final class Distribution {
    private final Strategy strategy;

    public Distribution(final Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * This method is used to call distributionGifts method using a children list
     * sorted by the current strategy.
     *
     * @param database database
     */
    public void executeStrategy(final Database database) {
        Action action = new Action();
        action.distributionGifts(strategy.childrenListSortByStrategy(database),
                database.getSantaGiftsList());
    }
}
