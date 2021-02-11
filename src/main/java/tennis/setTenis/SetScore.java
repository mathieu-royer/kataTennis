package tennis.setTenis;

import gameInterface.Score;
import gameInterface.SetTennisBuilder;

import java.util.ArrayList;
import java.util.Arrays;

public class SetScore implements Score {
    protected int[] players = new int[2];
    protected Score currentScore;
    protected ArrayList<Score> setGameScores = new ArrayList<>();
    protected  SetTennisBuilder setTennisBuilder;

    public SetScore(SetTennisBuilder builderScore) {
       players[0] = 0;
       players[1] = 0;
       setTennisBuilder = builderScore;
       currentScore = builderScore.createScore();
    }

    @Override
    public void addScorePlayer(int player) {
        if(!this.isFinish()) {
            this.currentScore.addScorePlayer(player);
            if(this.currentScore.isFinish()) {
                int gameWinner = this.currentScore.getWinner() - 1;
                this.players[gameWinner] += 1;
                this.setGameScores.add(this.currentScore);
                this.currentScore = setTennisBuilder.createScore();
            }
        }
    }

    @Override
    public boolean isFinish() {
        return this.players[0] >= 7 || this.players[1] >= 7;
    }

    @Override
    public int getWinner() {
        if(this.players[0] >= 7) {
            return 1;
        } else if(this.players[1] >= 7) {
            return 2;
        } else {
            return -1;
        }
    }

    public int getScorePlayerOne() {
        return players[0];
    }

    public int getScorePlayerTwo() {
        return players[1];
    }

    @Override
    public String toString() {
        return "Set Score : playerOne = " + players[0] +
                ", playerTwo = " + players[1];
    }
}
