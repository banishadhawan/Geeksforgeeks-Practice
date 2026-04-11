class Solution {
  public:
    int countIncreasing(vector<int>& arr) {
        int n = arr.size();
        int len = 1;
        int count = 0;  // start from 0
        
        for(int i = 1; i < n; i++) {
            if(arr[i] > arr[i-1]) {
                len++;
            } else {
                len = 1;
            }
            count += (len - 1);  // only size >=2
        }
        
        return count;
    }
};