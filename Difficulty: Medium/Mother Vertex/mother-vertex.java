class Solution {
    
    void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        
        for(int neigh : adj.get(node)) {
            if(!vis[neigh]) {
                dfs(neigh, adj, vis);
            }
        }
    }
    
    public int findMotherVertex(int V, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Build graph
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        
        boolean[] vis = new boolean[V];
        int candidate = -1;
        
        // Find potential mother vertex
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                dfs(i, adj, vis);
                candidate = i;
            }
        }
        
        // Verify candidate
        vis = new boolean[V];
        dfs(candidate, adj, vis);
        
        for(boolean visited : vis) {
            if(!visited) {
                return -1;
            }
        }
        
        return candidate;
    }
}