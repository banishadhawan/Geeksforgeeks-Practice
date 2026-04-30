class Solution {
    public boolean isMaxHeap(int[] arr) {
        int n = arr.length;
        
        // Check all non-leaf nodes
        for (int i = 0; i <= (n / 2) - 1; i++) {
            
            // Left child
            int left = 2 * i + 1;
            if (left < n && arr[i] < arr[left]) {
                return false;
            }
            
            // Right child
            int right = 2 * i + 2;
            if (right < n && arr[i] < arr[right]) {
                return false;
            }
        }
        
        return true;
    }
}