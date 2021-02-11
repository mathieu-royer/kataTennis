package tennis.gameTennis;

import gameInterface.Score;

import java.util.Arrays;

public class TieBreak implements Score {
    private int[] players = new int[2];

    public TieBreak() {
        players[0] = 0;
        players[1] = 0;
    }

    @Override
    public void addScorePlayer(int player) {
        if (!this.isFinish()) {
            this.players[player - 1] += 1;
        }
    }

    private boolean playerHasFinished(int player) {
        int player1 = player -1;
        int player2 = Math.abs(player1 - 1);
        if (players[player1] >= 7 && players[player1] - players[player2] >= 2) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isFinish() {
        return playerHasFinished(1) || playerHasFinished(2);
    }

    @Override
    public int getWinner() {
        if (playerHasFinished(1)) {
            return 1;
        } else if (playerHasFinished(2)) {
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
        return "Tie Break Score : playerOne = " + players[0] +
                ", playerTwo = " + players[1];
    }
}
