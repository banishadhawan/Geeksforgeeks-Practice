import java.util.*;

class Solution {
    
    long[] segTree;

    // GCD Function
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // LCM Function
    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    // Build Segment Tree
    private void build(int index, int low, int high, int[] arr) {

        if (low == high) {
            segTree[index] = arr[low];
            return;
        }

        int mid = low + (high - low) / 2;

        build(2 * index + 1, low, mid, arr);
        build(2 * index + 2, mid + 1, high, arr);

        segTree[index] = lcm(segTree[2 * index + 1],
                             segTree[2 * index + 2]);
    }

    // Update Query
    private void update(int index, int low, int high,
                        int pos, int val) {

        if (low == high) {
            segTree[index] = val;
            return;
        }

        int mid = low + (high - low) / 2;

        if (pos <= mid) {
            update(2 * index + 1, low, mid, pos, val);
        } else {
            update(2 * index + 2, mid + 1, high, pos, val);
        }

        segTree[index] = lcm(segTree[2 * index + 1],
                             segTree[2 * index + 2]);
    }

    // Range LCM Query
    private long query(int index, int low, int high,
                       int l, int r) {

        // No overlap
        if (high < l || low > r) {
            return 1;
        }

        // Complete overlap
        if (low >= l && high <= r) {
            return segTree[index];
        }

        int mid = low + (high - low) / 2;

        long left = query(2 * index + 1, low, mid, l, r);
        long right = query(2 * index + 2, mid + 1, high, l, r);

        return lcm(left, right);
    }

    public ArrayList<Long> RangeLCMQuery(int[] arr, int[][] queries) {

        int n = arr.length;

        segTree = new long[4 * n];

        build(0, 0, n - 1, arr);

        ArrayList<Long> ans = new ArrayList<>();

        for (int[] q : queries) {

            // Type 1 -> Update
            if (q[0] == 1) {

                int index = q[1];
                int value = q[2];

                update(0, 0, n - 1, index, value);
            }

            // Type 2 -> Range Query
            else {

                int l = q[1];
                int r = q[2];

                ans.add(query(0, 0, n - 1, l, r));
            }
        }

        return ans;
    }
}