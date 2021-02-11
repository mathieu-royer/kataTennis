package tennis.gameTennis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TieBreakTest {

    private TieBreak tieBreak;

    @BeforeEach
    public void init() {
        tieBreak = new TieBreak();
    }

    private void setSetScorePlayerOneBeforeWin() {
        tieBreak.addScorePlayer(1);
        tieBreak.addScorePlayer(1);
        tieBreak.addScorePlayer(1);
        tieBreak.addScorePlayer(1);
        tieBreak.addScorePlayer(1);
        tieBreak.addScorePlayer(1);
    }

    private void setSetScorePlayerTwoBeforeWin() {
        tieBreak.addScorePlayer(2);
        tieBreak.addScorePlayer(2);
        tieBreak.addScorePlayer(2);
        tieBreak.addScorePlayer(2);
        tieBreak.addScorePlayer(2);
        tieBreak.addScorePlayer(2);
    }

    @Test
    public void testInitGameScore() {
        assertEquals(0, tieBreak.getScorePlayerOne());
        assertEquals(0, tieBreak.getScorePlayerTwo());
    }

    @Test
    public void testAddScorePlayerOne() {
        tieBreak.addScorePlayer(1);
        assertEquals(1, tieBreak.getScorePlayerOne());
        assertEquals(0, tieBreak.getScorePlayerTwo());

    }

    @Test
    public void testAddScorePlayerTwo() {
        tieBreak.addScorePlayer(2);
        assertEquals(0, tieBreak.getScorePlayerOne());
        assertEquals(1, tieBreak.getScorePlayerTwo());
    }

    @Test
    public void testIsFinishByPlayerOne() {
        this.setSetScorePlayerOneBeforeWin();
        tieBreak.addScorePlayer(1);
        assertTrue(tieBreak.isFinish());
    }

    @Test
    public void testIsFinishByPlayerTwo() {
        this.setSetScorePlayerTwoBeforeWin();
        tieBreak.addScorePlayer(2);
        assertTrue(tieBreak.isFinish());
    }

    @Test
    public void testIsFinishAfter7Points() {
        this.setSetScorePlayerTwoBeforeWin();
        this.setSetScorePlayerOneBeforeWin();
        tieBreak.addScorePlayer(2);
        assertFalse(tieBreak.isFinish());
        tieBreak.addScorePlayer(2);
        assertTrue(tieBreak.isFinish());
        assertEquals(8, tieBreak.getScorePlayerTwo());
    }

    @Test
    public void testIsNotFinish() {
        tieBreak.addScorePlayer(1);
        tieBreak.addScorePlayer(2);
        tieBreak.addScorePlayer(2);
        assertFalse(tieBreak.isFinish());
    }

    @Test
    public void testGetWinnerPlayerOne() {
        tieBreak.addScorePlayer(1);
        tieBreak.addScorePlayer(1);
        tieBreak.addScorePlayer(1);
        tieBreak.addScorePlayer(1);
        assertEquals(1, tieBreak.getWinner());
    }

    @Test
    public void testGetWinnerPlayerTwo() {
        tieBreak.addScorePlayer(2);
        tieBreak.addScorePlayer(2);
        tieBreak.addScorePlayer(2);
        tieBreak.addScorePlayer(2);
        assertEquals(2, tieBreak.getWinner());
    }

    @Test
    public void testNotGetWinner() {
        tieBreak.addScorePlayer(1);
        tieBreak.addScorePlayer(1);
        tieBreak.addScorePlayer(2);
        assertEquals(-1, tieBreak.getWinner());
    }


}