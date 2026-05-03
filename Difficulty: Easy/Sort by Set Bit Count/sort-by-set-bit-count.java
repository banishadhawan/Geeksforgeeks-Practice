import java.util.*;

class Solution {
    ArrayList<Integer> sortBySetBitCount(int[] arr) {
        
        Integer[] temp = new Integer[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        
        // Sort based on set bit count (descending)
        Arrays.sort(temp, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);
            return countB - countA;
        });
        
        // Convert to ArrayList
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : temp) {
            result.add(num);
        }
        
        return result;
    }
}