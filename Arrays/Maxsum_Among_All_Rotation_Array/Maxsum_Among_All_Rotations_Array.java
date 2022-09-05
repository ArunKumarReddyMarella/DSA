package Maxsum_Among_All_Rotation_Array;
// Input:
// N = 4
// A[] = {8,3,1,2}
// Output: 29
// Explanation: Above the configuration
// possible by rotating elements are
// 3 1 2 8 here sum is 3*0+1*1+2*2+8*3 = 29
// 1 2 8 3 here sum is 1*0+2*1+8*2+3*3 = 27
// 2 8 3 1 here sum is 2*0+8*1+3*2+1*3 = 17
// 8 3 1 2 here sum is 8*0+3*1+1*2+2*3 = 11
// Here the max sum is 29 
import java.util.*;

class Maxsum_Among_All_Rotations_Array
{
    static int max_sum(int[] A, int n)
    {
        int total_sum=0,cur_val=0;;
        for(int i=0;i<n;i++){
            total_sum+=A[i];
            cur_val+=i*A[i];
        }
        int max_val=cur_val;
        for(int i=1;i<n;i++){
            int next_val=cur_val-total_sum+A[i-1]+A[i-1]*(n-1);
            cur_val=next_val;
            max_val=Math.max(max_val,cur_val);
            
        }
        return max_val;
    }	
	public  static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			
			System.out.println(max_sum(arr,n));	
		t--;
		}
	}
	
}