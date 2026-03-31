class Solution {
    private int solve(int[] prices, int fee, int[][] dp, int i, int day){
        if(i >= prices.length) return 0;

        if(dp[i][day]!=-1) return dp[i][day];
        int profit;

        if(day == 0){
            int buy = -prices[i]+solve(prices,fee,dp,i+1,1);
            int skip = solve(prices,fee,dp,i+1,0);
            profit = Math.max(buy,skip);
        }
        else{
            int sell = prices[i]-fee+solve(prices,fee,dp,i+1,0);
            int skip=solve(prices,fee,dp,i+1,1);
            profit=Math.max(sell,skip);
        }
        return dp[i][day] = profit;
    }
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int[][] dp = new int[n][2];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(prices,fee,dp,0,0);
    }
}