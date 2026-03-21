class Solution {

    static class Info {
        int size;
        int min;
        int max;
        boolean isBST;

        Info(int size, int min, int max, boolean isBST) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }

    static int largestBst(Node root) {
        return helper(root).size;
    }

    static Info helper(Node root) {
        if (root == null) {
            return new Info(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }

        Info left = helper(root.left);
        Info right = helper(root.right);

        if (left.isBST && right.isBST &&
            root.data > left.max && root.data < right.min) {

            int size = left.size + right.size + 1;
            int min = Math.min(root.data, left.min);
            int max = Math.max(root.data, right.max);

            return new Info(size, min, max, true);
        }

        return new Info(Math.max(left.size, right.size), 0, 0, false);
    }
}