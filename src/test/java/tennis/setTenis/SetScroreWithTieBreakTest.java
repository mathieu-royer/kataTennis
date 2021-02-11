package tennis.setTenis;

import gameInterface.Score;
import gameInterface.SetTennisBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class SetScroreWithTieBreakTest {

    @Mock
    Score gameScore;
    @Mock
    Score tieBreakScore;
    @Mock
    SetTennisBuilder setTennisBuilder;
    @Mock
    SetTennisBuilder setTennisBuilderTieBreak;


    @InjectMocks
    SetScore setScore;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        Mockito.when( gameScore.isFinish() ).thenReturn( true );
        Mockito.when( setTennisBuilder.createScore() ).thenReturn( gameScore );
        Mockito.when( tieBreakScore.isFinish() ).thenReturn( true );
        Mockito.when( setTennisBuilderTieBreak.createScore() ).thenReturn( tieBreakScore );
        setScore = new SetScroreWithTieBreak(setTennisBuilder, setTennisBuilderTieBreak);
    }

    private void setSetScorePlayerOneBeforeWin() {
        setScore.addScorePlayer(1);
        setScore.addScorePlayer(1);
        setScore.addScorePlayer(1);
        setScore.addScorePlayer(1);
        setScore.addScorePlayer(1);
        setScore.addScorePlayer(1);
    }

    private void setSetScorePlayerTwoBeforeWin() {
        setScore.addScorePlayer(2);
        setScore.addScorePlayer(2);
        setScore.addScorePlayer(2);
        setScore.addScorePlayer(2);
        setScore.addScorePlayer(2);
        setScore.addScorePlayer(2);
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
        this.setSetScorePlayerOneBeforeWin();
        setScore.addScorePlayer(1);
        assertTrue(setScore.isFinish());
        Mockito.verify( gameScore, Mockito.times( 7 ) ).isFinish();
        Mockito.verify( gameScore, Mockito.times( 7 ) ).getWinner();
    }

    @Test
    public void testIsFinishByPlayerTwo() {
        Mockito.when( gameScore.getWinner() ).thenReturn( 2 );
        this.setSetScorePlayerTwoBeforeWin();
        setScore.addScorePlayer(2);
        assertTrue(setScore.isFinish());
        Mockito.verify( gameScore, Mockito.times( 7 ) ).isFinish();
        Mockito.verify( gameScore, Mockito.times( 7 ) ).getWinner();
    }

    @Test
    public void testTileBreak() {
        Mockito.when( gameScore.getWinner() ).thenReturn( 2 );
        this.setSetScorePlayerTwoBeforeWin();
        Mockito.when( gameScore.getWinner() ).thenReturn( 1 );
        this.setSetScorePlayerOneBeforeWin();
        Mockito.when( tieBreakScore.getWinner() ).thenReturn( 1 );;
        this.setSetScorePlayerOneBeforeWin();
        setScore.addScorePlayer(1);
        assertTrue(setScore.isFinish());
        assertEquals(1, setScore.getWinner());
        Mockito.verify( gameScore, Mockito.times( 12 ) ).isFinish();
        Mockito.verify( gameScore, Mockito.times( 12 ) ).getWinner();
        Mockito.verify( tieBreakScore, Mockito.times( 1 ) ).isFinish();
        Mockito.verify( tieBreakScore, Mockito.times( 1 ) ).getWinner();
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
        this.setSetScorePlayerOneBeforeWin();
        setScore.addScorePlayer(1);
        assertEquals(1, setScore.getWinner());
        Mockito.verify( gameScore, Mockito.times( 7 ) ).isFinish();
        Mockito.verify( gameScore, Mockito.times( 7 ) ).getWinner();
    }

    @Test
    public void testGetWinnerPlayerTwo() {
        Mockito.when( gameScore.getWinner() ).thenReturn( 2 );
        this.setSetScorePlayerTwoBeforeWin();
        setScore.addScorePlayer(2);
        assertEquals(2, setScore.getWinner());
        Mockito.verify( gameScore, Mockito.times( 7 ) ).isFinish();
        Mockito.verify( gameScore, Mockito.times( 7 ) ).getWinner();
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