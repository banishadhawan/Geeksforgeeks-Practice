class Solution {
    public ArrayList<Integer> spirallyTraverse(int[][] mat) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        
        if(mat==null || mat.length==0) return res;
        
        int rowB=0, rowE=mat.length-1;
        int colB=0, colE=mat[0].length-1;
        
        while(rowB<=rowE && colB<=colE){
            //right
            for(int j=colB;j<=colE;j++){
                res.add(mat[rowB][j]);
            }
            rowB++;
            
            //down
            for(int i=rowB;i<=rowE;i++){
                res.add(mat[i][colE]);
            }
            colE--;
            
            
            //left
            if(rowB<=rowE){
                for(int j=colE;j>=colB;j--){
                    res.add(mat[rowE][j]);
                }
                rowE--;
            }
            
            
            //up
            if(colB<=colE){
                for(int i=rowE;i>=rowB;i--){
                    res.add(mat[i][colB]);
                }
                colB++;
            }
        }
        return res;
    }
}
