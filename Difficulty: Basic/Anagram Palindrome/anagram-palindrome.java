class Solution {
    boolean canFormPalindrome(String s) {
        // code here
        int[] freq = new int[256];
        
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)]++;
        }
        
        int count=0;
        
        for(int i=0;i<256;i++){
            if(freq[i] % 2 != 0){
                count++;
            }
        }
        
        return count<=1;
    }
}