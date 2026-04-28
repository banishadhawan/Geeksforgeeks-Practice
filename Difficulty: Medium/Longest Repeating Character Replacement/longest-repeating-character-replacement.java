class Solution {
    public int longestSubstr(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        
        int left = 0, maxFreq = 0, maxLen = 0;
        
        for (int right = 0; right < n; right++) {
            // Increase frequency
            freq[s.charAt(right) - 'A']++;
            
            // Update max frequency in window
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);
            
            // If replacements needed > k, shrink window
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            
            // Update result
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}