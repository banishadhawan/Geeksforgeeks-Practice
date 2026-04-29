class Solution {
    public int minSwaps(int[] arr) {
        int n = arr.length;

        // Step 1: Count total 1s
        int k = 0;
        for (int num : arr) {
            if (num == 1) k++;
        }

        // Edge case: no 1s
        if (k == 0) return -1;

        // Step 2: Count 1s in first window
        int countOnes = 0;
        for (int i = 0; i < k; i++) {
            if (arr[i] == 1) countOnes++;
        }

        int maxOnes = countOnes;

        // Step 3: Sliding window
        for (int i = k; i < n; i++) {
            if (arr[i] == 1) countOnes++;
            if (arr[i - k] == 1) countOnes--;

            maxOnes = Math.max(maxOnes, countOnes);
        }

        // Step 4: Minimum swaps
        return k - maxOnes;
    }
}