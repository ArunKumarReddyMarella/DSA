import java.util.*;
class power{
    static double calculate(int a,int b){
        if(b==0)
            return 1;
        double k=calculate(a,b/2);
        if(b%2==0)
            return k*k;
        else
            return k*k*a;
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int a= sc.nextInt();
            int b= sc.nextInt();
            System.out.println(calculate(a,b));
        }
    }
}