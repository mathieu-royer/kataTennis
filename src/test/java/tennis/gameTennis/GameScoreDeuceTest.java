package tennis.gameTennis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameScoreDeuceTest {
    private GameScoreDeuce gameScore;

    @BeforeEach
    public void init() {
        gameScore = new GameScoreDeuce();
    }

    private void setGameScoreToEgality40() {
        gameScore.addScorePlayer(1);
        gameScore.addScorePlayer(1);
        gameScore.addScorePlayer(1);
        gameScore.addScorePlayer(2);
        gameScore.addScorePlayer(2);
        gameScore.addScorePlayer(2);
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
    public void testAddScorePlayerOneAdvantage() {
        this.setGameScoreToEgality40();
        gameScore.addScorePlayer(1);
        assertEquals(TennisPlayerScore.ADVANTAGE, gameScore.getScorePlayerOne());
        assertEquals(TennisPlayerScore.FORTYADV, gameScore.getScorePlayerTwo());
    }

    @Test
    public void testAddScorePlayerTwoAdvantage() {
        this.setGameScoreToEgality40();
        gameScore.addScorePlayer(2);
        assertEquals(TennisPlayerScore.ADVANTAGE, gameScore.getScorePlayerTwo());
        assertEquals(TennisPlayerScore.FORTYADV, gameScore.getScorePlayerOne());
    }

    @Test
    public void testAddScorePlayerOneWinAfterAdvantage() {
        this.setGameScoreToEgality40();
        gameScore.addScorePlayer(1);
        gameScore.addScorePlayer(1);
        assertEquals(TennisPlayerScore.WIN, gameScore.getScorePlayerOne());
        assertEquals(TennisPlayerScore.FORTYADV, gameScore.getScorePlayerTwo());
    }

    @Test
    public void testAddScorePlayerTwoWinAfterAdvantage() {
        this.setGameScoreToEgality40();
        gameScore.addScorePlayer(2);
        gameScore.addScorePlayer(2);
        assertEquals(TennisPlayerScore.FORTYADV, gameScore.getScorePlayerOne());
        assertEquals(TennisPlayerScore.WIN, gameScore.getScorePlayerTwo());
    }

    @Test
    public void testAddScorePlayerDeuce() {
        this.setGameScoreToEgality40();
        gameScore.addScorePlayer(1);
        gameScore.addScorePlayer(2);
        assertEquals(TennisPlayerScore.DEUCE, gameScore.getScorePlayerOne());
        assertEquals(TennisPlayerScore.DEUCE, gameScore.getScorePlayerTwo());
    }

    @Test
    public void testAddScorePlayerOneAdvantageAfterDeuce() {
        this.setGameScoreToEgality40();
        gameScore.addScorePlayer(1);
        gameScore.addScorePlayer(2);
        gameScore.addScorePlayer(1);
        assertEquals(TennisPlayerScore.ADVANTAGE, gameScore.getScorePlayerOne());
        assertEquals(TennisPlayerScore.FORTYADV, gameScore.getScorePlayerTwo());
    }

    @Test
    public void testAddScorePlayerTwoAdvantageAfterDeuce() {
        this.setGameScoreToEgality40();
        gameScore.addScorePlayer(1);
        gameScore.addScorePlayer(2);
        gameScore.addScorePlayer(2);
        assertEquals(TennisPlayerScore.FORTYADV, gameScore.getScorePlayerOne());
        assertEquals(TennisPlayerScore.ADVANTAGE, gameScore.getScorePlayerTwo());
    }

    @Test
    public void testIsFinishByPlayerOne() {
        this.setGameScoreToEgality40();
        gameScore.addScorePlayer(1);
        gameScore.addScorePlayer(1);
        assertTrue(gameScore.isFinish());
    }

    @Test
    public void testIsFinishByPlayerTwo() {
        this.setGameScoreToEgality40();
        gameScore.addScorePlayer(2);
        gameScore.addScorePlayer(2);
        assertTrue(gameScore.isFinish());
    }

    @Test
    public void testIsNotFinish() {
        this.setGameScoreToEgality40();
        gameScore.addScorePlayer(1);
        gameScore.addScorePlayer(2);
        gameScore.addScorePlayer(2);
        assertFalse(gameScore.isFinish());
    }

    @Test
    public void testGetWinnerPlayerOne() {
        this.setGameScoreToEgality40();
        gameScore.addScorePlayer(1);
        gameScore.addScorePlayer(1);
        assertEquals(1, gameScore.getWinner());
    }

    @Test
    public void testGetWinnerPlayerTwo() {
        this.setGameScoreToEgality40();
        gameScore.addScorePlayer(2);
        gameScore.addScorePlayer(2);
        assertEquals(2, gameScore.getWinner());
    }

    @Test
    public void testNotGetWinner() {
        this.setGameScoreToEgality40();
        gameScore.addScorePlayer(1);
        gameScore.addScorePlayer(2);
        assertEquals(-1, gameScore.getWinner());
    }

}