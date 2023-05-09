package searching.subarray_with_given_sum;

import java.util.ArrayList;

public class SubArraySum {
    static ArrayList<Integer> subarraySum_A(int[] arr, int n, int s) {
        ArrayList<Integer> pair = new ArrayList<>();
        int sum = arr[0];
        int start = 0,end = 0;
        while(start < n && end < n){
            if(sum == s){
                pair.add(start+1);
                pair.add(end+1);
                break;
            }
            if(sum < s){
                if(end == n-1)
                    break;
                end++;
                sum += arr[end];
            }
            else if(sum > s){
                if(start < end){
                    sum -= arr[start];
                    start++;
                }
                else if(start == end)
                {
                    if(start == n-1 || end == n-1)
                        break;
                    sum -= arr[start];
                    start++;
                    end++;
                    sum += arr[end];
                }
            }
        }
        if(pair.size() == 0)
            pair.add(-1);
        
        return pair;
    }
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        ArrayList<Integer> pair = new ArrayList<>();
        int sum = arr[0];
        int start = 0;
        
        for(int i=1;i<=n;i++){
            while(sum > s && start < i-1){
                sum-=arr[start++];
            }
            if(sum == s)
            {
                pair.add(start+1);
                pair.add(i);
                return pair;
            }
            if(i<n)
                sum+=arr[i];
        }
        if(pair.size() == 0)
            pair.add(-1);
        
        return pair;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,7,5};
        int n = arr.length;
        int s = 12;
        ArrayList<Integer> pair = subarraySum(arr, n, s);
        System.out.println(pair);
        pair = subarraySum_A(arr, n, s);
        System.out.println(pair);
    }
}
