package gameInterface;

public interface Score {

    void addScorePlayer(int player);
    boolean isFinish();
    int getWinner();
    String printScore();
}
