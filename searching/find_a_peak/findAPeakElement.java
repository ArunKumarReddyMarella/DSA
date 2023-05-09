package searching.find_a_peak;

public class findAPeakElement {
    static int findPeak(int arr[]){
        int low = 0;
        int high = arr.length-1;
        int n = arr.length;
        while(low <= high){
            int mid = (low + high) >> 1;
            if((mid == 0 || arr[mid-1] <= arr[mid]) && (mid == n-1 || arr[mid+1] <= arr[mid]))
                return mid;
            if(mid > 0 && arr[mid-1] > arr[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
    public static void main(String args[])
	{
		//int arr[] = { 1, 3, 20, 4, 1, 0 };
        int arr[] = {2,2};
		int index = findPeak(arr);
        if(index < 0)
            System.out.println("No peak found");
        else
		    System.out.println("Index of a peak point is "
						+ index);
	}

}
