package tennis.gameTennis;

public enum TennisPlayerScore {
    WIN("WIN", null),
    FORTY("40", WIN),
    THIRTY("30", FORTY),
    FIFTEEN("15", THIRTY),
    ZERO("0", FIFTEEN),
    ADVANTAGE("ADV", WIN),
    DEUCE("Deuce", ADVANTAGE),
    FORTYADV("40", DEUCE);

    private String stringScore;
    private TennisPlayerScore nextScore;

    TennisPlayerScore(String stringScore, TennisPlayerScore nextScore) {
        this.stringScore = stringScore;
        this.nextScore = nextScore;
    }


    public TennisPlayerScore getNextScore() {
        return nextScore;
    }

    public static TennisPlayerScore[] getNextScore(TennisPlayerScore player1, TennisPlayerScore player2) {
        TennisPlayerScore[] scoresPlayers = new TennisPlayerScore[2];

        if(player1.equals(player2) && (player1.equals(FORTY) || player1.equals(DEUCE))) {
            scoresPlayers[0] = ADVANTAGE;
            scoresPlayers[1] = FORTYADV;
        } else {
            player1 = player1.getNextScore();
            if(player1.equals(DEUCE)) {
                scoresPlayers[0] = DEUCE;
                scoresPlayers[1] = DEUCE;
            } else {
                scoresPlayers[0] = player1;
                scoresPlayers[1] = player2;
            }
        }
        return  scoresPlayers;
    }

    @Override
    public String toString() {
        return stringScore;
    }

}
