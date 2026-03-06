class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        int n = arr.length;
        
        if (k > n) return 0;

        int currentXor = 0;
        
        // XOR of first window
        for (int i = 0; i < k; i++) {
            currentXor ^= arr[i];
        }
        
        int maxXor = currentXor;

        // Slide the window
        for (int i = k; i < n; i++) {
            // Remove left element
            currentXor ^= arr[i - k];
            
            // Add new element
            currentXor ^= arr[i];
            
            maxXor = Math.max(maxXor, currentXor);
        }

        return maxXor;
    }
}