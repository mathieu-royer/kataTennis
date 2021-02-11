package tennis.setTenis;

import gameInterface.Score;
import gameInterface.ScoreTennisBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class SetScoreTest {

    @Mock
    Score gameScore;
    @Mock
    ScoreTennisBuilder scoreTennisBuilder;


    @InjectMocks
    SetScore setScore;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        Mockito.when( gameScore.isFinish() ).thenReturn( true );
        Mockito.when( scoreTennisBuilder.createScore() ).thenReturn( gameScore );
        setScore = new SetScore(scoreTennisBuilder);

    }

    private void setSetScorePlayerOneToWin() {
        setScore.addScorePlayer(1);
        setScore.addScorePlayer(1);
        setScore.addScorePlayer(1);
        setScore.addScorePlayer(1);
        setScore.addScorePlayer(1);
        setScore.addScorePlayer(1);
        setScore.addScorePlayer(1);
    }

    private void setSetScorePlayerTwoToWin() {
        setScore.addScorePlayer(2);
        setScore.addScorePlayer(2);
        setScore.addScorePlayer(2);
        setScore.addScorePlayer(2);
        setScore.addScorePlayer(2);
        setScore.addScorePlayer(2);
        setScore.addScorePlayer(2);
    }

    private void setSetScorePlayerToWinWith7() {
        Mockito.when( gameScore.getWinner() ).thenReturn( 1 );
        setScore.addScorePlayer(1);
        setScore.addScorePlayer(1);
        setScore.addScorePlayer(1);
        setScore.addScorePlayer(1);
        setScore.addScorePlayer(1);

        Mockito.when( gameScore.getWinner() ).thenReturn( 2 );
        setScore.addScorePlayer(2);
        setScore.addScorePlayer(2);
        setScore.addScorePlayer(2);
        setScore.addScorePlayer(2);
        setScore.addScorePlayer(2);

        Mockito.when( gameScore.getWinner() ).thenReturn( 1 );
        setScore.addScorePlayer(1);
        setScore.addScorePlayer(1);
    }

    @Test
    public void testInitGameScore() {
        assertEquals(0, setScore.getScorePlayerOne());
        assertEquals(0, setScore.getScorePlayerTwo());
    }

    @Test
    public void testAddScorePlayerOne() {
        Mockito.when( gameScore.getWinner() ).thenReturn( 1 );
        setScore.addScorePlayer(1);
        assertEquals(1, setScore.getScorePlayerOne());
        assertEquals(0, setScore.getScorePlayerTwo());
        Mockito.verify( gameScore, Mockito.times( 1 ) ).isFinish();
        Mockito.verify( gameScore, Mockito.times( 1 ) ).getWinner();
    }

    @Test
    public void testAddScorePlayerTwo() {
        Mockito.when( gameScore.getWinner() ).thenReturn( 2 );
        setScore.addScorePlayer(2);
        assertEquals(0, setScore.getScorePlayerOne());
        assertEquals(1, setScore.getScorePlayerTwo());
        Mockito.verify( gameScore, Mockito.times( 1 ) ).isFinish();
        Mockito.verify( gameScore, Mockito.times( 1 ) ).getWinner();
    }

    @Test
    public void testIsFinishByPlayerOne() {
        Mockito.when( gameScore.getWinner() ).thenReturn( 1 );
        this.setSetScorePlayerOneToWin();
        assertTrue(setScore.isFinish());
        Mockito.verify( gameScore, Mockito.times( 6 ) ).isFinish();
        Mockito.verify( gameScore, Mockito.times( 6 ) ).getWinner();
    }

    @Test
    public void testIsFinishByPlayerTwo() {
        Mockito.when( gameScore.getWinner() ).thenReturn( 2 );
        this.setSetScorePlayerTwoToWin();
        assertTrue(setScore.isFinish());
        Mockito.verify( gameScore, Mockito.times( 6 ) ).isFinish();
        Mockito.verify( gameScore, Mockito.times( 6 ) ).getWinner();
    }

    @Test
    public void testIsFinishByPlayerWithScore7() {
        this.setSetScorePlayerToWinWith7();
        assertTrue(setScore.isFinish());
        assertEquals(7, setScore.getScorePlayerOne());
        Mockito.verify( gameScore, Mockito.times( 12 ) ).isFinish();
        Mockito.verify( gameScore, Mockito.times( 12 ) ).getWinner();
    }

    @Test
    public void testIsNotFinish() {
        Mockito.when( gameScore.getWinner() ).thenReturn( 1 );
        setScore.addScorePlayer(1);
        Mockito.when( gameScore.getWinner() ).thenReturn( 2 );
        setScore.addScorePlayer(2);
        setScore.addScorePlayer(2);
        assertFalse(setScore.isFinish());
        Mockito.verify( gameScore, Mockito.times( 3 ) ).isFinish();
        Mockito.verify( gameScore, Mockito.times( 3 ) ).getWinner();
    }

    @Test
    public void testGetWinnerPlayerOne() {
        Mockito.when( gameScore.getWinner() ).thenReturn( 1 );
        this.setSetScorePlayerOneToWin();
        assertEquals(1, setScore.getWinner());
        Mockito.verify( gameScore, Mockito.times( 6 ) ).isFinish();
        Mockito.verify( gameScore, Mockito.times( 6 ) ).getWinner();
    }

    @Test
    public void testGetWinnerPlayerTwo() {
        Mockito.when( gameScore.getWinner() ).thenReturn( 2 );
        this.setSetScorePlayerTwoToWin();
        assertEquals(2, setScore.getWinner());
        Mockito.verify( gameScore, Mockito.times( 6 ) ).isFinish();
        Mockito.verify( gameScore, Mockito.times( 6 ) ).getWinner();
    }

    @Test
    public void testNotGetWinner() {
        Mockito.when( gameScore.getWinner() ).thenReturn( 1 );
        setScore.addScorePlayer(1);
        setScore.addScorePlayer(1);
        Mockito.when( gameScore.getWinner() ).thenReturn( 2 );
        setScore.addScorePlayer(2);
        assertEquals(-1, setScore.getWinner());
        Mockito.verify( gameScore, Mockito.times( 3 ) ).isFinish();
        Mockito.verify( gameScore, Mockito.times( 3 ) ).getWinner();
    }

}