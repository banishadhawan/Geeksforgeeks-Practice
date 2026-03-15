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

class Pair {
    Node node;
    int hd;

    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

class Solution {
    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        while(!q.isEmpty()) {

            Pair p = q.poll();
            Node curr = p.node;
            int hd = p.hd;

            if(!map.containsKey(hd))
                map.put(hd, new ArrayList<>());

            map.get(hd).add(curr.data);

            if(curr.left != null)
                q.add(new Pair(curr.left, hd - 1));

            if(curr.right != null)
                q.add(new Pair(curr.right, hd + 1));
        }

        for(ArrayList<Integer> list : map.values())
            ans.add(list);

        return ans;
    }
}