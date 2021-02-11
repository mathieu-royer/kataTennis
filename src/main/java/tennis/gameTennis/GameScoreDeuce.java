package tennis.gameTennis;


public class GameScoreDeuce extends GameScore {


    public GameScoreDeuce() {
        super();
    }

    @Override
    public void addScorePlayer(int player) {
        if(!this.isFinish()) {
            int player1 = player - 1;
            int player2 = Math.abs(player1 - 1);
            TennisPlayerScore[] playerScores = TennisPlayerScore.getNextScore(super.players[player1], super.players[player2]);
            super.players[player1] = playerScores[0];
            super.players[player2] = playerScores[1];
        }
    }
}
