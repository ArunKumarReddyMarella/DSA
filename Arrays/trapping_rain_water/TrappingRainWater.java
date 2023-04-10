package trapping_rain_water;

import java.util.Stack;

public class TrappingRainWater {
    //O(3N,2N)
    public static int maxWater_Prefix(int[] arr, int n)
	{
		// To store the maximum water
		// that can be stored
		int res = 0;

		// For every element of the array
		// except first and last element
		for (int i = 1; i < n - 1; i++) {

			// Find maximum element on its left
			int left = arr[i];
			for (int j = 0; j < i; j++) {
				left = Math.max(left, arr[j]);
			}

			// Find maximum element on its right
			int right = arr[i];
			for (int j = i + 1; j < n; j++) {
				right = Math.max(right, arr[j]);
			}

			// Update maximum water value
			res += Math.min(left, right) - arr[i];
		}
		return res;
	}
    //O(2N,N)
    public static long maxWater_Stack(int[] arr){
        int n = arr.length;
        long water = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.empty() && arr[i] > arr[stack.peek()]) {
                int top = stack.pop();
                if (!stack.empty()) {
                    int width = i - stack.peek() - 1;
                    int height = Math.min(arr[i], arr[stack.peek()]) - arr[top];
                    water +=(long)(width * height);
                }
            }
            stack.push(i);
        }
        return water;
    }

    public static void main(String[] args)
	{
		int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int n = arr.length;

		System.out.println(maxWater_Prefix(arr, n));
        System.out.println(maxWater_Stack(arr));
	}
}
