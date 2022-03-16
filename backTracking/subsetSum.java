import java.util.*;
class subsetSum{
    static Boolean check(int[] ar,int n, int k,int idx,int s){
        if(idx==n){
            return s==k;
        }
        return check(ar,n,k,idx+1,s+ar[idx])||check(ar,n,k,idx+1,s);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ar=new int[n];
        for (int i=0; i <n;i++)
            ar[i] = scanner.nextInt();
        int k=scanner.nextInt();
        System.out.println(check(ar,n,k,0,0));
    }
}