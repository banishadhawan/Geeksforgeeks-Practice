class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        int n=arr.length;
        int[] freq = new int[n+1];
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int num:arr){
            freq[num]++;
        }
        int dup=-1, mis=-1;
        
        for(int i=1;i<=n;i++){
            if(freq[i]==2){
                dup=i;
            }
            else if(freq[i]==0){
                mis=i;
            }
        }
        res.add(dup);
        res.add(mis);
        return res;
    }
}

