package action;

import annual.AnnualChange;
import database.Database;

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

        if (this.roundNumber != 0) {
            action.increaseAge(database);

            currentAnnualChange = database.getAnnualChangeList().get(this.roundNumber - 1);
            database.setSantaBudget(currentAnnualChange.getNewSantaBudget());

            action.addNewChildren(database, currentAnnualChange.getNewChildren());

            database.getSantaGiftsList().addAll(currentAnnualChange.getNewGifts());

            action.updateChild(database, currentAnnualChange);
        }

        action.sortGifts(database);
        action.distributionGifts(database, action.budgetUnit(database));
    }
}
