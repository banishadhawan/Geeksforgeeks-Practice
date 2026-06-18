class Solution {
    public List<String> powerSet(String s) {
       List<String> ans = new ArrayList<>();
        solve(0, s, "", ans);
        
        Collections.sort(ans); // if lexicographical order is required
        return ans;
    }
    
    private void solve(int idx, String s, String curr, List<String> ans) {
        if (idx == s.length()) {
            ans.add(curr);
            return;
        }
        
        // Include current character
        solve(idx + 1, s, curr + s.charAt(idx), ans);
        
        // Exclude current character
        solve(idx + 1, s, curr, ans);
    }
}

