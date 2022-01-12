package action;

import annual.AnnualChange;
import database.Database;
import strategy.Distribution;
import strategy.IdStrategy;
import strategy.NiceScoreCityStrategy;
import strategy.NiceScoreStrategy;

public final class Round {
    private final Integer roundNumber;

    public Round(final Integer roundNumber) {
        this.roundNumber = roundNumber;
    }

    /**
     * This method is used to start a round.
     * If it is the first round, the gifts will be distributed.
     * If it is not the first round, the ages will increase, updates
     * will be added and gifts will be distributed.
     *
     * @param database database
     */
    public void currentRound(final Database database) {
        Action action = new Action();
        AnnualChange currentAnnualChange;
        Distribution distribution = new Distribution(new IdStrategy());

        if (this.roundNumber != 0) {
            currentAnnualChange = database.getAnnualChangeList().get(this.roundNumber - 1);

            switch (currentAnnualChange.getStrategy()) {
                case NICE_SCORE -> distribution = new Distribution(new NiceScoreStrategy());
                case NICE_SCORE_CITY -> distribution = new Distribution(new NiceScoreCityStrategy());
            }

            action.increaseAge(database);
            database.setSantaBudget(currentAnnualChange.getNewSantaBudget());

            action.addNewChildren(database, currentAnnualChange.getNewChildren());

            database.getSantaGiftsList().addAll(currentAnnualChange.getNewGifts());

            action.updateChild(database, currentAnnualChange);
        }

        action.sortGifts(database);
        action.setChildrenAssignedBudget(database, action.budgetUnit(database));
        distribution.executeStrategy(database);
        action.yellowElf(database);
    }
}
