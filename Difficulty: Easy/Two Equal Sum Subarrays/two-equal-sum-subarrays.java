class Solution {
    public boolean canSplit(int arr[]) {
        int total = 0;
        
        // Step 1: Calculate total sum
        for(int num : arr) {
            total += num;
        }
        
        // Step 2: If total is odd → not possible
        if(total % 2 != 0) return false;
        
        int prefixSum = 0;
        
        // Step 3: Check prefix sum
        for(int i = 0; i < arr.length - 1; i++) {
            prefixSum += arr[i];
            
            if(prefixSum == total / 2) {
                return true;
            }
        }
        
        return false;
    }
}