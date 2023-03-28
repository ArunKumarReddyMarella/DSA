package lucky_number;

public class LuckyNumber {
    public static boolean isLucky_recursion(int n, int c){
        if(c>n)
            return true;
        if(n%c == 0)
            return false;
        return isLucky_recursion(n - n/c,c+1);
    }
    public static boolean isLucky_iteration(int n){
        int c=2;
        while(c <= n){
            if(n%c == 0)
                return false;
            
            n=n - n/c;
            c++;
        }
        return true;
    }
    public static void main(String[] args) {
        int n =5;
        System.out.println(isLucky_recursion(n, 2));
        //System.out.println(isLucky_iteration(n));
    }
    
}
