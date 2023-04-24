package frequencies_of_elements_of_given_ranges;

public class MaximumOccuredIntegerInRanges {
    public static int maxOccured(int L[], int R[], int n, int maxx){
        int[] freq= new int[maxx+2];
        for(int i=0;i<n;i++){
            freq[L[i]]++;
            freq[R[i]+1]--;
        }
        int max_sum = freq[0];
        int max_index = 0;
        for(int i=1;i<=maxx;i++){
            freq[i]+=freq[i-1];
            if(max_sum < freq[i]){
                max_sum = freq[i];
                max_index = i;
            }
        }
        return max_index;
    }
    static public void main(String[] args)
	{
        int[] L = { 1, 4, 9, 13, 21 };
		int[] R = { 15, 8, 12, 20, 30 };
      	// int L[] = {1, 2, 3};
      	// int R[] = {3, 5 , 7};
		int n = L.length;
        int maxx = 0;
        for(int i=0;i<n;i++)
            maxx = Math.max(maxx,R[i]);
		System.out.println(maxOccured(L, R, n,maxx));
	}
}
