class Solution {

    public int countSpanTree(int n, int[][] edges) {

        // Special case
        if (n == 1) return 1;

        int[][] lap = new int[n][n];

        // Build Laplacian Matrix
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            lap[u][u]++;
            lap[v][v]++;

            lap[u][v]--;
            lap[v][u]--;
        }

        // Create cofactor matrix (remove 0th row & column)
        int[][] mat = new int[n - 1][n - 1];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                mat[i - 1][j - 1] = lap[i][j];
            }
        }

        return determinant(mat, n - 1);
    }

    // Function to calculate determinant
    private int determinant(int[][] mat, int n) {

        if (n == 1)
            return mat[0][0];

        int det = 0;
        int sign = 1;

        for (int col = 0; col < n; col++) {

            int[][] temp = new int[n - 1][n - 1];

            for (int i = 1; i < n; i++) {
                int j2 = 0;

                for (int j = 0; j < n; j++) {
                    if (j == col)
                        continue;

                    temp[i - 1][j2++] = mat[i][j];
                }
            }

            det += sign * mat[0][col] * determinant(temp, n - 1);

            sign = -sign;
        }

        return det;
    }
}