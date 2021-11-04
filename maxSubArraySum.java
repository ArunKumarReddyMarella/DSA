class maxSubArraySum {
    static long maxSubarraySum(int arr[], int n) {
        long cm = 0, ma = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            cm += arr[i];
            ma = Math.max(ma, cm);
            cm = Math.max(0, cm);
        }
        return ma;
    }

    public static void main(String[] args) {
        int[] arr = { -1, 2, 3, 4, 5, -2, -10 };
        System.out.println(maxSubarraySum(arr, 7));
    }
}