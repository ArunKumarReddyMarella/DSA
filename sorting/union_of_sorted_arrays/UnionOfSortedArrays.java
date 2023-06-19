package sorting.union_of_sorted_arrays;

import java.util.ArrayList;

public class UnionOfSortedArrays {
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
        ArrayList<Integer> result = new ArrayList<>();
        int i=0,j=0;
        while(i<n && j<m){
            if(i!=0 && arr1[i]==arr1[i-1]){
                i++;
                continue;
            }
            if(j!=0 && arr2[j]==arr2[j-1]){
                j++;
                continue;
            }
            if(arr1[i]<arr2[j]){
                result.add(arr1[i++]);
            }
            else if(arr1[i] > arr2[j]){
                result.add(arr2[j++]);
            }
            else{
                result.add(arr1[i]);
                i++;
                j++;
            }
        }
        while(i<n){
            if(i!=0 && arr1[i]==arr1[i-1]){
                i++;
                continue;
            }
            result.add(arr1[i++]);
        }
        while(j<m){
            if(j!=0 && arr2[j]==arr2[j-1]){
                j++;
                continue;
            }
            result.add(arr2[j++]);
        }
        return result;
    }
}
