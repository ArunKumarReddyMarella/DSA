import java.util.*;

class kthSmallestElement {
    // (nlogk,k)
    public static int kthSmallest(int[] arr, int l, int r, int k) {
        // Your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        for (i = 0; i < k; i++)
            pq.add(arr[i]);
        for (; i < arr.length; i++) {
            if (pq.peek() > arr[i]) {
                pq.poll();
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    }
}