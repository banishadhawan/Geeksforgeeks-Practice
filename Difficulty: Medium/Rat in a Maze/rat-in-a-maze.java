class Solution {
    
    static String dir = "DLRU";
    static int[] dr = {1, 0, 0, -1};
    static int[] dc = {0, -1, 1, 0};
    
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> ans = new ArrayList<>();
        int n = maze.length;
        
        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0)
            return ans;
            
        boolean[][] vis = new boolean[n][n];
        
        solve(0, 0, maze, vis, "", ans);
        
        return ans;
    }
    
    private void solve(int row, int col, int[][] maze,
                       boolean[][] vis, String path,
                       ArrayList<String> ans) {
        
        int n = maze.length;
        
        if (row == n - 1 && col == n - 1) {
            ans.add(path);
            return;
        }
        
        vis[row][col] = true;
        
        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];
            
            if (newRow >= 0 && newRow < n &&
                newCol >= 0 && newCol < n &&
                maze[newRow][newCol] == 1 &&
                !vis[newRow][newCol]) {
                    
                solve(newRow, newCol, maze, vis,
                      path + dir.charAt(i), ans);
            }
        }
        
        vis[row][col] = false;
    }
}