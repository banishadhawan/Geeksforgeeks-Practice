class Solution {
    public int kBitFlips(int[] arr, int k) {
        int n = arr.length;
        int flips = 0;
        int currFlip = 0;
        int[] isFlipped = new int[n];

        for (int i = 0; i < n; i++) {

            if (i >= k) {
                currFlip ^= isFlipped[i - k];
            }

            if (arr[i] == currFlip) {

                if (i + k > n) return -1;

                flips++;
                currFlip ^= 1;
                isFlipped[i] = 1;
            }
        }

        return flips;
    }
}