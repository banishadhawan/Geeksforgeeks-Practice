class Solution {
    public int countPartitions(int[] arr, int diff) {
        int n = arr.length;
        
        int totalSum = 0;
        for (int num : arr) totalSum += num;
        
        // Edge cases
        if ((totalSum + diff) % 2 != 0 || totalSum < diff)
            return 0;
        
        int target = (totalSum + diff) / 2;
        
        return countSubsets(arr, target);
    }
    
    private int countSubsets(int[] arr, int target) {
        int n = arr.length;
        
        int[][] dp = new int[n + 1][target + 1];
        
        // Base case
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int sum = 0; sum <= target; sum++) {
                
                if (arr[i - 1] <= sum) {
                    dp[i][sum] = dp[i - 1][sum] 
                               + dp[i - 1][sum - arr[i - 1]];
                } else {
                    dp[i][sum] = dp[i - 1][sum];
                }
            }
        }
        
        return dp[n][target];
    }
}