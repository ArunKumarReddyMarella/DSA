import java.util.*;
class generateValidParanthsis{
    static void generate(char[] ar,int n,int idx,int open,int close){
        if(idx==n){
            System.out.println(ar);
            return;
        }
        if(open < n/2){
            ar[idx]='(';
            generate(ar,n,idx+1,open+1,close);
        }
        if(close < open){
            ar[idx]=')';
            generate(ar,n,idx+1,open,close+1);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        char[] ar=new char[n];
        generate(ar,n,0,0,0);
    }
}