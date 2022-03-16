import java.util.*;
class subsetSum{
    static Boolean checkBit(int x,int y){
        return ((x>>y)&1)==1;
    }
    static Boolean check(int[] arr,int n, int k){
        for(int i=0;i<(1<<n);i++){
            int s=0;
            for(int j=0;j<n; j++){
                if(checkBit(j,i))
                    s+=arr[j];
            }
            System.out.print(s+" ");
            if(s==k)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        int k=sc.nextInt();
        System.out.println(check(arr,n,k));
    }
}