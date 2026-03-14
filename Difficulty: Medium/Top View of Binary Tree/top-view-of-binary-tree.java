/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
import java.util.*;

class Pair {
    Node node;
    int val;

    Pair(Node node, int val) {
        this.node = node;
        this.val = val;
    }
}

class Solution {
    public ArrayList<Integer> topView(Node root) {

        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        // root has horizontal distance 0
        q.offer(new Pair(root, 0));     //adding (inserting) an element into a queue

        while (!q.isEmpty()) {
            Pair fr = q.poll();
            Node temp = fr.node;
            int val = fr.val;

            // store first node of each horizontal distance
            if (!map.containsKey(val)) {
                map.put(val, temp.data);
            }

            if (temp.left != null) {
                q.offer(new Pair(temp.left, val - 1));
            }

            if (temp.right != null) {
                q.offer(new Pair(temp.right, val + 1));
            }
        }

        for (int valu : map.values()) {
            ans.add(valu);
        }

        return ans;
    }
}
