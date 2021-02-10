package tennis.gameTennis;

public enum TennisPlayerScore {
    WIN("WIN", null),
    FORTY("40", WIN),
    THIRTY("30", FORTY),
    FIFTEEN("15", THIRTY),
    ZERO("0", FIFTEEN);

    private String stringScore;
    private TennisPlayerScore nextScore;

    TennisPlayerScore(String stringScore, TennisPlayerScore nextScore) {
        this.stringScore = stringScore;
        this.nextScore = nextScore;
    }

    public TennisPlayerScore getNextScore() {
        return nextScore;
    }

    @Override
    public String toString() {
        return stringScore;
    }

}
