class Solution {
    public int countSquare(int[][] mat, int x) {
        // code here
        int n=mat.length, m=mat[0].length;
        int[][] prefix=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                prefix[i][j] = mat[i-1][j-1]+prefix[i-1][j]+prefix[i][j-1]-prefix[i-1][j-1];
            }
        }
        int count=0;
        for(int size=1;size<=Math.min(n,m);size++){
            for(int i=0;i+size<=n;i++){
                for(int j=0;j+size<=m;j++){
                    int r1=i, c1=j;
                    int r2=i+size, c2=j+size;
                    
                    int sum=prefix[r2][c2]-prefix[r1][c2]-prefix[r2][c1] + prefix[r1][c1];
                    if(sum==x) count++;
                }
            }
        }
        return count;
    }
}