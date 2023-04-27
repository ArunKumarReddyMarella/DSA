public class FloorOfSquareRoot{
    public static int floorSqrt(int x)
	{
		// Base Cases
		if (x == 0 || x == 1)
			return x;
		long start = 1, end = x / 2, ans = 0;
		while (start <= end) {
			long mid = (start + end) / 2;

			// If x is a perfect square
			if (mid * mid == x)
				return (int)mid;

			// Since we need floor, we update answer when
			// mid*mid is smaller than x, and move closer to
			// sqrt(x)
			if (mid * mid < x) {
				start = mid + 1;
				ans = mid;
			}
			else // If mid*mid is greater than x
				end = mid - 1;
		}
		return (int)ans;
	}

	// Driver Method
	public static void main(String args[])
	{
		int x = 17;
		System.out.println(floorSqrt(x));
	}
}