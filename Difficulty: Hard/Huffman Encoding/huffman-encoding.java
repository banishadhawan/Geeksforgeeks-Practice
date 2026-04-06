import java.util.*;

class Solution {

    static class Node {
        int freq;
        int idx;
        Node left, right;

        Node(int f, int i) {
            freq = f;
            idx = i;
        }
    }

    static class MyComp implements Comparator<Node> {
        public int compare(Node a, Node b) {
            if (a.freq == b.freq) return a.idx - b.idx;
            return a.freq - b.freq;
        }
    }

    static void preorder(Node root, String code, ArrayList<String> ans) {
        if (root == null) return;

        // Leaf node
        if (root.left == null && root.right == null) {
            // 🔥 FIX: if single node, assign "0"
            if (code.length() == 0) ans.add("0");
            else ans.add(code);
            return;
        }

        preorder(root.left, code + "0", ans);
        preorder(root.right, code + "1", ans);
    }

    public ArrayList<String> huffmanCodes(String s, int f[]) {

        PriorityQueue<Node> pq = new PriorityQueue<>(new MyComp());

        for (int i = 0; i < f.length; i++) {
            pq.add(new Node(f[i], i));
        }

        // Edge case handled here also (optional safe check)
        if (pq.size() == 1) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add("0");
            return ans;
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            Node parent = new Node(left.freq + right.freq, Math.min(left.idx, right.idx));
            parent.left = left;
            parent.right = right;

            pq.add(parent);
        }

        ArrayList<String> ans = new ArrayList<>();
        preorder(pq.poll(), "", ans);

        return ans;
    }
}