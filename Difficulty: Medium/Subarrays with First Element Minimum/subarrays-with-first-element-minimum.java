class Solution {
    public int countSubarrays(int[] arr) {
        // code here
        int n=arr.length;
        Stack<Integer> st = new Stack<>();
        int ans=0;
        
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            
            int nextSmall = st.isEmpty() ? n : st.peek();
            ans += (nextSmall-i);
            st.push(i);
        }
        return ans;
    }
}
