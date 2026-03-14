class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int n=stalls.length;
        
        int left=1, right=stalls[n-1] - stalls[0];
        while(left <= right){
            int mid=left+(right-left)/2;
            if(canplace(mid,stalls,k)) left=mid+1;
            else right=mid-1;
        }
        return right;
    }
    
    private boolean canplace(int mid, int[] stalls,int k){
        int cows=1, prev=stalls[0];
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-prev >= mid){
                cows++;
                prev=stalls[i];
            }
        }
        
        return cows>=k;
    }
}