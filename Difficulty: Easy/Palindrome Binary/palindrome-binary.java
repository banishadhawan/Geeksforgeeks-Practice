class Solution {
    public boolean isBinaryPalindrome(int n) {
        String binary = Integer.toBinaryString(n);
        
        int left = 0;
        int right = binary.length() - 1;
        
        while (left < right) {
            if (binary.charAt(left) != binary.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}