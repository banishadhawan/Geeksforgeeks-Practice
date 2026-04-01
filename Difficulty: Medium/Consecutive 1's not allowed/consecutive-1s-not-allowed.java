class Solution {
    int countStrings(int n) {
        int a = 1; // ending with 0
        int b = 1; // ending with 1
        
        for(int i = 2; i <= n; i++) {
            int newA = a + b;
            int newB = a;
            
            a = newA;
            b = newB;
        }
        
        return a + b;
    }
}