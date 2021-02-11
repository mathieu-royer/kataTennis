package tennis.gameTennis;

import gameInterface.Score;

public class GameScore implements Score {

    protected TennisPlayerScore[] players = new TennisPlayerScore[2] ;

    public GameScore() {
        players[0] = TennisPlayerScore.ZERO;
        players[1] = TennisPlayerScore.ZERO;
    }

    @Override
    public void addScorePlayer(int player) {
        if(!this.isFinish()) {
            int numPlayer = player - 1;
            this.players[numPlayer] = this.players[numPlayer].getNextScore();
        }
    }

    @Override
    public boolean isFinish() {
        return this.players[0].equals(TennisPlayerScore.WIN) || this.players[1].equals(TennisPlayerScore.WIN);
    }

    @Override
    public int getWinner() {
        if(this.players[0].equals(TennisPlayerScore.WIN)) {
            return 1;
        } else if(this.players[1].equals(TennisPlayerScore.WIN)) {
            return 2;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return  "Game Score : playerOne = " + players[0] +
                ", playerTwo = " + players[1];
    }

    public TennisPlayerScore getScorePlayerOne() {
        return this.players[0];
    }

    public TennisPlayerScore getScorePlayerTwo() {
        return this.players[1];
    }
}
