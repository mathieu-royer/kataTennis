package tennis.setTenis;

import gameInterface.SetTennisBuilder;

public class SetScroreWithTieBreak extends SetScore{

    private  SetTennisBuilder setTennisBuilderTiereak;
    private boolean isTieBreak = false;

    public SetScroreWithTieBreak(SetTennisBuilder builderScore, SetTennisBuilder builderScoreTieBreak) {
        super(builderScore);
        setTennisBuilderTiereak = builderScoreTieBreak;
    }

    @Override
    public void addScorePlayer(int player) {
        if(this.isScorePlayer66() && !isTieBreak) {
            super.currentScore = setTennisBuilderTiereak.createScore();
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
