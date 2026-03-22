class Solution {
    public int orangesRot(int[][] mat) {
        //code here
        int n = mat.length;
        int m = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 2){
                    q.add(new int[]{i, j});
                }
                else if(mat[i][j] == 1){
                    count++;
                }
            }
        }
        if(count == 0) return 0;
        int time = 0;
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            int size = q.size();
            boolean rot = false;
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                for(int[] d : dir){
                    int ni = curr[0] + d[0];
                    int nj = curr[1] + d[1];
                    if(ni >= 0 && nj >= 0 && ni < n && nj < m && mat[ni][nj] == 1){
                        mat[ni][nj] = 2;
                        q.add(new int[]{ni, nj});
                        count--;
                        rot = true;
                    }
                }
            }
            if(rot) time++;
        }
        return count == 0 ? time : -1;
    }
}