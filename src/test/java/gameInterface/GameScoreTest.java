package gameInterface;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tennis.gameTennis.GameScore;
import tennis.gameTennis.TennisPlayerScore;

import static org.junit.jupiter.api.Assertions.*;

class GameScoreTest {

    private GameScore gameScore;

    @BeforeEach
    public void init() {
        gameScore = new GameScore();
    }

    @Test
    public void testInitGameScore() {
        assertEquals(TennisPlayerScore.ZERO, gameScore.getScorePlayerOne());
        assertEquals(TennisPlayerScore.ZERO, gameScore.getScorePlayerTwo());
    }

    @Test
    public void testAddScorePlayerOne() {
        gameScore.addScorePlayer(1);
        assertEquals(TennisPlayerScore.FIFTEEN, gameScore.getScorePlayerOne());
        assertEquals(TennisPlayerScore.ZERO, gameScore.getScorePlayerTwo());

    }

    @Test
    public void testAddScorePlayerTwo() {
        gameScore.addScorePlayer(2);
        assertEquals(TennisPlayerScore.ZERO, gameScore.getScorePlayerOne());
        assertEquals(TennisPlayerScore.FIFTEEN, gameScore.getScorePlayerTwo());
    }

    @Test
    public void testIsFinishByPlayerOne() {
        gameScore.addScorePlayer(1);
        gameScore.addScorePlayer(1);
        gameScore.addScorePlayer(1);
        gameScore.addScorePlayer(1);
        assertTrue(gameScore.isFinish());
    }

    @Test
    public void testIsFinishByPlayerTwo() {
        gameScore.addScorePlayer(2);
        gameScore.addScorePlayer(2);
        gameScore.addScorePlayer(2);
        gameScore.addScorePlayer(2);
        assertTrue(gameScore.isFinish());
    }

    @Test
    public void testIsNotFinish() {
        gameScore.addScorePlayer(1);
        gameScore.addScorePlayer(2);
        gameScore.addScorePlayer(2);
        assertFalse(gameScore.isFinish());
    }

    @Test
    public void testGetWinnerPlayerOne() {
        gameScore.addScorePlayer(1);
        gameScore.addScorePlayer(1);
        gameScore.addScorePlayer(1);
        gameScore.addScorePlayer(1);
        assertEquals(1, gameScore.getWinner());
    }

    @Test
    public void testGetWinnerPlayerTwo() {
        gameScore.addScorePlayer(2);
        gameScore.addScorePlayer(2);
        gameScore.addScorePlayer(2);
        gameScore.addScorePlayer(2);
        assertEquals(2, gameScore.getWinner());
    }

    @Test
    public void testNotGetWinner() {
        gameScore.addScorePlayer(1);
        gameScore.addScorePlayer(1);
        gameScore.addScorePlayer(2);
        assertEquals(-1, gameScore.getWinner());
    }

}