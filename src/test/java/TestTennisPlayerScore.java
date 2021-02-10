import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tennis.gameTennis.TennisPlayerScore;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTennisPlayerScore {

    private TennisPlayerScore playerScore;

    @BeforeEach
    void initTennisScorePlayer() {
        playerScore = TennisPlayerScore.ZERO;
    }

    @Test
    void testNextScoreAfterZero() {
        assertEquals(TennisPlayerScore.ZERO, playerScore);
        assertEquals(TennisPlayerScore.FIFTEEN, playerScore.getNextScore());
    }

    @Test
    void testNextScoreAfterFifteen() {
        playerScore = playerScore.getNextScore();
        assertEquals(TennisPlayerScore.FIFTEEN, playerScore);
        assertEquals(TennisPlayerScore.THIRTY, playerScore.getNextScore());
    }

    @Test
    void testNextScoreAfterThirty() {
        playerScore = playerScore.getNextScore();
        playerScore = playerScore.getNextScore();
        assertEquals(TennisPlayerScore.THIRTY, playerScore);
        assertEquals(TennisPlayerScore.FORTY, playerScore.getNextScore());
    }

    @Test
    void testNextScoreAfterForty() {
        playerScore = playerScore.getNextScore();
        playerScore = playerScore.getNextScore();
        playerScore = playerScore.getNextScore();
        assertEquals(TennisPlayerScore.FORTY, playerScore);
        assertEquals(TennisPlayerScore.WIN, playerScore.getNextScore());
    }
}
