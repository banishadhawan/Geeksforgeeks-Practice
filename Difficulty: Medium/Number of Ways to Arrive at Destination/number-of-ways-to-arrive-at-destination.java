import java.util.*;

class Solution {
    public int countPaths(int V, int[][] edges) {
        int mod = (int)1e9 + 7;
        ArrayList<ArrayList<long[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1], wt = e[2];
            adj.get(u).add(new long[]{v, wt});
            adj.get(v).add(new long[]{u, wt});
        }

        // Step 2: Dijkstra setup
        long[] dist = new long[V];
        Arrays.fill(dist, Long.MAX_VALUE);
        int[] ways = new int[V];

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        dist[0] = 0;
        ways[0] = 1;
        pq.offer(new long[]{0, 0}); // {distance, node}

        // Step 3: Dijkstra
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long d = curr[0];
            int node = (int) curr[1];

            if (d > dist[node]) continue;

            for (long[] nei : adj.get(node)) {
                int adjNode = (int) nei[0];
                long wt = nei[1];

                if (d + wt < dist[adjNode]) {
                    dist[adjNode] = d + wt;
                    ways[adjNode] = ways[node];
                    pq.offer(new long[]{dist[adjNode], adjNode});
                } 
                else if (d + wt == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        return ways[V - 1];
    }
}