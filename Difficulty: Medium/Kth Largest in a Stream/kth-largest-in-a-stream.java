import java.util.*;

class Solution {
    static ArrayList<Integer> kthLargest(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // Min Heap
        
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            
            if (pq.size() > k) {
                pq.poll(); // remove smallest
            }
            
            if (pq.size() == k) {
                result.add(pq.peek()); // kth largest
            } else {
                result.add(-1);
            }
        }
        
        return result;
    }
}