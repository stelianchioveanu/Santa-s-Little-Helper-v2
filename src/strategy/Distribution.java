package strategy;

import action.Action;
import database.Database;

public class Distribution {
    private final Strategy strategy;

    public Distribution(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(Database database){
        Action action = new Action();
        action.distributionGifts(strategy.childrenListSortByStrategy(database), database.getSantaGiftsList());
    }
}
