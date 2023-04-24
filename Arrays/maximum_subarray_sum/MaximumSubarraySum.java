package maximum_subarray_sum;

public class MaximumSubarraySum {
    static int maxSubarraySum(int[] arr){
        int size = arr.length;
        int maxSum = 0;
        int maxEnding = 0;
        for(int i=0;i<size;i++){
            maxEnding = Math.max(maxEnding+arr[i], arr[i]);
            maxSum = Math.max(maxEnding, maxSum);
        }
        //if contiguous sub-array(containing at least one number)
        // int maxEnding = arr[0];
        // int maxSum = arr[0];

        // for (int i = 1; i < n; i++) {
        //     maxEnding = Math.max(maxEnding + arr[i], arr[i]);
        //     maxSum = Math.max(maxSum, maxEnding);
        // }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] arr = {-1,-2,8,-4};

        int res = maxSubarraySum(arr);
        System.out.println(res);
    }
}
