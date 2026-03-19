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
    
    public int minTime(Node root, int target) {
        
        HashMap<Node, Node> parentMap = new HashMap<>();
        
        // Step 2: Find target node
        Node targetNode = markParent(root, parentMap, target);
        
        // Step 3: BFS to burn tree
        return burnTree(targetNode, parentMap);
    }
    
    private Node markParent(Node root, HashMap<Node, Node> parentMap, int target) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        Node targetNode = null;
        
        while (!q.isEmpty()) {
            Node curr = q.poll();
            
            if (curr.data == target) {
                targetNode = curr;
            }
            
            if (curr.left != null) {
                parentMap.put(curr.left, curr);
                q.offer(curr.left);
            }
            
            if (curr.right != null) {
                parentMap.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
        
        return targetNode;
    }
    
    private int burnTree(Node targetNode, HashMap<Node, Node> parentMap) {
        
        Queue<Node> q = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();
        
        q.offer(targetNode);
        visited.add(targetNode);
        
        int time = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            boolean burned = false;
            
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                
                // left
                if (curr.left != null && !visited.contains(curr.left)) {
                    burned = true;
                    visited.add(curr.left);
                    q.offer(curr.left);
                }
                
                // right
                if (curr.right != null && !visited.contains(curr.right)) {
                    burned = true;
                    visited.add(curr.right);
                    q.offer(curr.right);
                }
                
                // parent
                if (parentMap.containsKey(curr) && !visited.contains(parentMap.get(curr))) {
                    burned = true;
                    visited.add(parentMap.get(curr));
                    q.offer(parentMap.get(curr));
                }
            }
            
            if (burned) time++;
        }
        
        return time;
    }
}