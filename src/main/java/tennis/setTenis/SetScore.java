package tennis.setTenis;

import gameInterface.Score;
import gameInterface.ScoreTennisBuilder;

import java.util.ArrayList;

public class SetScore implements Score {
    protected int[] players = new int[2];
    protected Score currentScore;
    protected ArrayList<Score> setGameScores = new ArrayList<>();
    protected ScoreTennisBuilder scoreTennisBuilder;

    public SetScore(ScoreTennisBuilder builderScore) {
       players[0] = 0;
       players[1] = 0;
       scoreTennisBuilder = builderScore;
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
                this.currentScore = scoreTennisBuilder.createScore();
            }
        }
    }

    @Override
    public boolean isFinish() {
        if(this.getWinner() != -1){
            return true;
        }
        return false;
    }

    @Override
    public int getWinner() {
        if((this.players[0] >= 6 && this.players[0] - players[1] >= 2) || this.players[0] >= 7) {
            return 1;

        } else if((this.players[1] >= 6 && this.players[1] - players[0] >= 2) || this.players[1] >= 7) {
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

    @Override
    public String printScore() {
        return this.currentScore.printScore() + System.lineSeparator() +
                this.toString();
    }
}
