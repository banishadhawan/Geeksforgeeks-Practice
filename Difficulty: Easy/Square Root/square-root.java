class Solution {
    int floorSqrt(int n) {
        // code here
        int ans=0;
        int low=0, high=n;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            
            if((long)mid*mid <= n){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
}