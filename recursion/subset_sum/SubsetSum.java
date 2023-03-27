package subset_sum;
//Number of subsets with sum
public class SubsetSum {
    //T(2^n+2^(n-1))
    public static void main(String[] args) {
        int arr[]= {10,20,15,5}, sum = 15;
        System.out.println(checkSum(arr,arr.length,sum));
    }

    private static int checkSum(int[] arr,int n, int sum) {
        if(n==0)
            return sum==0?1:0;
        
        return checkSum(arr, n-1, sum)+checkSum(arr, n-1, sum-arr[n-1]);
    }
    
}
