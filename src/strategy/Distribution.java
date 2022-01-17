package strategy;

import action.Action;
import database.Database;

public final class Distribution {
    private final Strategy strategy;

    public Distribution(final Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(final Database database) {
        Action action = new Action();
        action.distributionGifts(strategy.childrenListSortByStrategy(database),
                database.getSantaGiftsList());
    }
}
