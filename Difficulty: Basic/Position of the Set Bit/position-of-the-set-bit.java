class Solution {
    public int findPosition(int n) {
        // Check if n has exactly one set bit
        if (n == 0 || (n & (n - 1)) != 0) {
            return -1;
        }
        
        int position = 1;
        
        // Find position of the only set bit
        while (n > 0) {
            if ((n & 1) == 1) {
                return position;
            }
            n = n >> 1;
            position++;
        }
        
        return -1;
    }
}