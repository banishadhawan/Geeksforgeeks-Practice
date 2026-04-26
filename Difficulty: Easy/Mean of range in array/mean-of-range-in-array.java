class Solution {
    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();

     
        int[] prefix = new int[n];
        prefix[0] = arr[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

    
        for (int[] q : queries) {
            int L = q[0];
            int R = q[1];

            int sum;
            if (L == 0) {
                sum = prefix[R];
            } else {
                sum = prefix[R] - prefix[L - 1];
            }

            int length = R - L + 1;
            int mean = sum / length;  

            result.add(mean);
        }

        return result;
    }
}