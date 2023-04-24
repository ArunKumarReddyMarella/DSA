package Mathematics.number_game;

public class NumberGame {
    static long mod = 1000000007L;
    static Long numGame(Long n) {
        long minDivisibleNumber = 1L;
        for(long i=2;i<=n;i++){
            minDivisibleNumber = lcm(minDivisibleNumber,i)%mod;
        }
        return minDivisibleNumber%mod;
    }
    private static long lcm(long minDivisibleNumber, long i) {
        return (minDivisibleNumber*i)/gcd(minDivisibleNumber,i);
    }
    private static long gcd(long minDivisibleNumber, long i) {
        if(i==0)
            return minDivisibleNumber;
        return gcd(i,minDivisibleNumber%i);
    }
    public static void main(String[] args) {
        System.out.println(numGame(100000L));
    }
}
