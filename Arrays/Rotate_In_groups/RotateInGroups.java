package Rotate_In_groups;

import java.util.ArrayList;

public class RotateInGroups {
    static void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        // code here
        int i=0;
        while(i<n){
            int start = i;
            int end = i+k-1;
            if(end>=n)
                end = n-1;
            while(start < end){
                int temp = arr.get(start);
                arr.set(start,arr.get(end));
                arr.set(end, temp);
                start++;
                end--;
            }
            i=i+k;
            
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        int k = 3;
        reverseInGroups(arr, 5, k);
        System.out.println(arr);

    }
}
