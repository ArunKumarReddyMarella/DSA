package searching.sum_pair_2P;

import java.util.ArrayList;
import java.util.List;

public class PairSum {
    static List<Integer> pair(int arr[],int n,int target){
        List<Integer> pair = new ArrayList<>();
        int low = 0;
        int high = n-1;
        while(low < high){
            int sum = arr[low]+ arr[high];
            if(sum == target){
                pair.add(low);
                pair.add(high);
                break;
            }
            else if(sum < target)
                low++;
            else 
                high--;
        }
        return pair;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2,3,4,5,6};
        int target = 9;
        System.out.println(pair(arr, arr.length, target));
    }
}
