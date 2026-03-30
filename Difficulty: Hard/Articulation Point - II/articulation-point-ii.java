class Solution {
    static int timer;
    
    static void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj,
                    boolean[] vis, int[] disc, int[] low, boolean[] isAP) {
        
        vis[node] = true;
        disc[node] = low[node] = timer++;
        int child = 0;
        
        for (int neigh : adj.get(node)) {
            if (neigh == parent) continue;
            
            if (!vis[neigh]) {
                dfs(neigh, node, adj, vis, disc, low, isAP);
                low[node] = Math.min(low[node], low[neigh]);
                
                if (parent != -1 && low[neigh] >= disc[node]) {
                    isAP[node] = true;
                }
                
                child++;
            } else {
                low[node] = Math.min(low[node], disc[neigh]);
            }
        }
        
        if (parent == -1 && child > 1) {
            isAP[node] = true;
        }
    }
    
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
     
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        boolean[] vis = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] isAP = new boolean[V];
        
        timer = 0;
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, -1, adj, vis, disc, low, isAP);
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (isAP[i]) res.add(i);
        }
        
        if (res.size() == 0) {
            res.add(-1);
        }
        
        return res;
    }
}