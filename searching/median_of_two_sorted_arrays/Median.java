package searching.median_of_two_sorted_arrays;

public class Median {
    public static int findMedian(int a1[], int n, int a2[], int m)
    {
        //Your code here
        int start = 0, end = n;
        while(start <= end){
            int i1 = (start+end)/2;
            int i2 = (n+m+1)/2 - i1;
            
            int min1 = (i1 == n)?Integer.MAX_VALUE:a1[i1];
			int max1 = (i1 == 0)?Integer.MIN_VALUE:a1[i1 - 1];
			
			int min2 = (i2 == m)?Integer.MAX_VALUE:a2[i2];
			int max2 = (i2 == 0)?Integer.MIN_VALUE:a2[i2 - 1];
			
			if(max1 <= min2 && max2 <= min1){
			    if((n+m)%2 == 0){
			        return (Math.max(max1,max2)+Math.min(min1,min2))/2;
			    }
			    return Math.max(max1,max2);
			}
			else if(max1 > min2)
			    end = i1-1;
			else
			    start = i1+1;
        }
        return -1;
    }
    public static void main(String args[]) 
    {

		int a1[] = {10, 20, 30, 40, 50}, n1 = 5, a2[] = {5, 15, 25, 35, 45}, n2 = 5;
		
        System.out.println(findMedian(a1, n1,a2, n2));


    } 
    
}
