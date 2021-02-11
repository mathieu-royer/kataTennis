import gameInterface.Score;
import gameInterface.ScoreTennisBuilder;
import tennis.gameTennis.GameScoreDeuce;
import tennis.gameTennis.TieBreak;
import tennis.setTenis.SetScroreWithTieBreak;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayMatch {

    private static ScoreTennisBuilder getGameTennisBuilder() {
        return () -> new GameScoreDeuce();
    }

    private static ScoreTennisBuilder getTieBreakBuilder() {
        return () -> new TieBreak();
    }

    public static Score createGame() {
        SetScroreWithTieBreak setTieBreak = new SetScroreWithTieBreak(getGameTennisBuilder(), getTieBreakBuilder());
        return setTieBreak;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("The set of match start");
        Score match = createGame();
        System.out.print(" Start Game score ");
        System.out.println(match.printScore());
        while(!match.isFinish()) {
            int player = 0;
            while(player == 0) {
                System.out.println("Enter the player that win the game of set (1 or 2) ");
                Scanner sc = new Scanner(System.in);
                try{
                   player = sc.nextInt();
                } catch (InputMismatchException e){
                    System.out.println("Values accepted are 1 or 2 ");
                    player = 0;
                }
                if(player != 1 && player != 2 && player != 0) {
                    player = 0;
                    System.out.println("Values accepted are 1 or 2 ");
                }

            }
            System.out.println("Vous avez saisi le player " + player);
            match.addScorePlayer(player);
            System.out.println(match.printScore());
        }
        System.out.println("The winner is player : " + match.getWinner());

    }
}
