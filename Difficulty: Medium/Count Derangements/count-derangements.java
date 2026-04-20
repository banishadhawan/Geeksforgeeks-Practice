class Solution {
    public int derangeCount(int n) {
        // code here
        if(n==1) return 0; //if only one element, then no dearrangement poss
        if(n==2) return 1; //only 1 dearr pos for 2 ele  => [2,1]
        
        int[] dp = new int[n+1];
        
        dp[1] = 0;
        dp[2] = 1;
        
        for(int i=3;i<=n;i++){
            dp[i] = (i-1) * (dp[i-1]+dp[i-2]);
        }
        return dp[n];
    }
};