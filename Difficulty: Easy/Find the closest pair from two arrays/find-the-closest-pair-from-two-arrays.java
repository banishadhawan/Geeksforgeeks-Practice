class Solution {
    public static ArrayList<Integer> findClosestPair(int arr1[], int arr2[], int x) {
        // code here
        int n=arr1.length;
        int m=arr2.length;
        
        int maxdif=Integer.MAX_VALUE;
        int res1=0;
        int res2=0;
        
        int i=0, j=m-1;
        while(i<n && j>=0){
            int sum=arr1[i]+arr2[j];
            int diff=Math.abs(sum-x);
            
            if(diff < maxdif){
                maxdif = diff;
                res1=arr1[i];
                res2=arr2[j];
            }
            
            if(sum<x)i++;
            else j--;
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(res1);
        result.add(res2);
        return result;
    }
}