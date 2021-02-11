package tennis.setTenis;

import gameInterface.ScoreTennisBuilder;

public class SetScroreWithTieBreak extends SetScore{

    private ScoreTennisBuilder scoreTennisBuilderTiereak;
    private boolean isTieBreak = false;

    public SetScroreWithTieBreak(ScoreTennisBuilder builderScore, ScoreTennisBuilder builderScoreTieBreak) {
        super(builderScore);
        scoreTennisBuilderTiereak = builderScoreTieBreak;
    }

    @Override
    public void addScorePlayer(int player) {
        if(this.isScorePlayer66() && !isTieBreak) {
            super.currentScore = scoreTennisBuilderTiereak.createScore();
            isTieBreak = true;
        }
        super.addScorePlayer(player);
    }

    private boolean isScorePlayer66() {
        if(super.players[0] == 6 && super.players[1] == 6) {
            return true;
        }
        return false;
    }
}
