class Solution {
    public int[] stableMarriage(int[][] men, int[][] women) {
        int n = men.length;

        int[] wife = new int[n];     
        int[] husband = new int[n];  

        Arrays.fill(wife, -1);
        Arrays.fill(husband, -1);

        int[] next = new int[n];

        int[][] rank = new int[n][n];
        for (int w = 0; w < n; w++) {
            for (int i = 0; i < n; i++) {
                rank[w][women[w][i]] = i;
            }
        }

        Queue<Integer> freeMen = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            freeMen.add(i);
        }

        while (!freeMen.isEmpty()) {
            int m = freeMen.poll();

            int w = men[m][next[m]];
            next[m]++;

            if (husband[w] == -1) {
                husband[w] = m;
                wife[m] = w;
            } else {
                int m1 = husband[w];

                if (rank[w][m] < rank[w][m1]) {
                    husband[w] = m;
                    wife[m] = w;

                    wife[m1] = -1;
                    freeMen.add(m1);
                } else {
                    freeMen.add(m);
                }
            }
        }

        return wife;
    }
}