class Solution {
    public boolean checkSubsequenceSum(int[] arr, int k) {
        return solve(0, k, arr);
    }

    boolean solve(int idx, int target, int[] arr) {
        if (target == 0) return true;

        if (idx == arr.length) return false;

        // Take current element
        if (arr[idx] <= target && solve(idx + 1, target - arr[idx], arr)) {
            return true;
        }

        // Don't take current element
        return solve(idx + 1, target, arr);
    }
}