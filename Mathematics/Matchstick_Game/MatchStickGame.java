package Mathematics.Matchstick_Game;

public class MatchStickGame {
    static int matchGame(Long N) {
         return N%5==0?-1:Integer.parseInt(""+N%5);
    }
    public static void main(String[] args) {
        System.out.println(matchGame(48L));
    }
}
