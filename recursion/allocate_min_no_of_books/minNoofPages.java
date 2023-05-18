package recursion.allocate_min_no_of_books;

public class minNoofPages {
    public static void main(String args[]) 
    { 
        int arr[]={10,20,30,30};
        int n=arr.length;
        int k=2;
        
    	System.out.print(minPages(arr,n,k)); 
    }
    //O(n-1 C k-1)
    private static int minPages(int[] arr, int n, int k) {
        if(n==1)
            return arr[0];
        if(k==1)
            return sum(arr,0,n-1);
        int res = Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            res = Math.min(res,Math.max(minPages(arr, i, k-1),sum(arr,i,n-1)));
        }

        return res;
    }

    public static int sum(int arr[],int b, int e){
        int s=0;
        for(int i=b;i<=e;i++)
            s+=arr[i];
        return s;
    }
}
