class Solution {
    public boolean searchMatrix(int[][] mat, int x) {
        // code here
        int row=mat.length;
        int col =mat[0].length;
        
        int low=0, high=row*col-1;
        
        while(low<=high){
            int mid=(low+high)/2;
            
            int r=mid/col;
            int c=mid%col;
            
            if(mat[r][c]==x) return true;
            else if(mat[r][c]<x) low=mid+1;
            else high=mid-1;
        }
        return false;
    }
}
