class Solution {
    public int totalWays(int[] arr, int target) {
        int sum = 0;
        
        for (int num : arr) {
            sum += num;
        }

        if ((sum + target) % 2 != 0 || sum < Math.abs(target)) {
            return 0;
        }

        int newTarget = (sum + target) / 2;

        int[] dp = new int[newTarget + 1];
        dp[0] = 1; 

        for (int num : arr) {
            for (int j = newTarget; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[newTarget];
    }
}