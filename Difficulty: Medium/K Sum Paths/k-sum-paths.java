/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    int count = 0;
    
    public int countAllPaths(Node root, int k) {
        ArrayList<Integer> path = new ArrayList<>();
        dfs(root, k, path);
        return count;
    }
    
    void dfs(Node node, int k, ArrayList<Integer> path) {
        if (node == null) return;
        
        path.add(node.data);
        
        int sum = 0;
        
        // check all subpaths ending at this node
        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i);
            if (sum == k) count++;
        }
        
        dfs(node.left, k, path);
        dfs(node.right, k, path);
        
        // backtrack
        path.remove(path.size() - 1);
    }
}