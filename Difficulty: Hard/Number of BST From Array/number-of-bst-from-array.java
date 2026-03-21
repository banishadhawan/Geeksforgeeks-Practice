import java.util.*;

class Solution {
    public ArrayList<Integer> countBSTs(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        
        // Step 1: Precompute Catalan numbers
        int[] catalan = new int[n + 1];
        catalan[0] = 1;
        catalan[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }
        
        // Step 2: For each element as root
        for (int i = 0; i < n; i++) {
            int leftCount = 0;
            int rightCount = 0;
            
            for (int j = 0; j < n; j++) {
                if (arr[j] < arr[i]) leftCount++;
                else if (arr[j] > arr[i]) rightCount++;
            }
            
            int ways = catalan[leftCount] * catalan[rightCount];
            result.add(ways);
        }
        
        return result;
    }
}