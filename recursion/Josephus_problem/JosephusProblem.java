package Josephus_problem;

/**
 * JosephusProblem
 */
public class JosephusProblem {
    public static int josephus(int n, int k)
    {
        //Your code here
        if(n==1)
            return 1;
            
        return (josephus(n-1,k)+k-1)%n + 1;
    }

    public static void main(String[] args) {
        System.out.println(josephus(5,3));;
    }
}