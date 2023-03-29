package Mathematics.Matchstick_Game;

public class MatchStickGame {
    //Two friends, A and B, are playing the game of matchsticks. In this game, a group of N matchsticks is placed on the table. The players can pick any number of matchsticks from 1 to 4 (both inclusive) during their chance. The player who takes the last match stick wins the game.
    static int matchGame(Long N) {
         return N%5==0?-1:Integer.parseInt(""+N%5);
    }
    public static void main(String[] args) {
        System.out.println(matchGame(48L));
    }
}
