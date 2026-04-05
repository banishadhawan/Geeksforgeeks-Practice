class Solution {
    static ArrayList<Integer> diagView(int mat[][]) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = mat.length;
        int m = mat[0].length;

        // Step 1: Start from first row
        for (int col = 0; col < m; col++) {
            int i = 0, j = col;
            while (i < n && j >= 0) {
                res.add(mat[i][j]);
                i++;
                j--;
            }
        }

        // Step 2: Start from last column (excluding first row)
        for (int row = 1; row < n; row++) {
            int i = row, j = m - 1;
            while (i < n && j >= 0) {
                res.add(mat[i][j]);
                i++;
                j--;
            }
        }

        return res;
    }
}