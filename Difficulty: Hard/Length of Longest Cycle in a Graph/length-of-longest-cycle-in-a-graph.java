class Solution {
    public int longestCycle(int V, int[][] edges) {
        
       
        int[] next = new int[V];
        Arrays.fill(next, -1);
        
        for (int[] e : edges) {
            next[e[0]] = e[1];
        }
        
        boolean[] visited = new boolean[V];
        int maxCycle = -1;

        // Step 2: Traverse each node
        for (int i = 0; i < V; i++) {
            if (visited[i]) continue;

            HashMap<Integer, Integer> map = new HashMap<>();
            int curr = i;
            int step = 0;

            while (curr != -1) {
                if (visited[curr]) {
                    // cycle check
                    if (map.containsKey(curr)) {
                        int cycleLen = step - map.get(curr);
                        maxCycle = Math.max(maxCycle, cycleLen);
                    }
                    break;
                }

                visited[curr] = true;
                map.put(curr, step++);
                curr = next[curr];
            }
        }

        return maxCycle;
    }
}