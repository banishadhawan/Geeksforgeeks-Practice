import java.util.*;

class Solution {
    public ArrayList<Integer> reducePairs(int[] arr) {
        ArrayList<Integer> st = new ArrayList<>();

        for (int num : arr) {

            boolean alive = true;

            while (alive && !st.isEmpty()) {
                int top = st.get(st.size() - 1);

                // check opposite signs
                if ((top > 0 && num < 0) || (top < 0 && num > 0)) {

                    int absTop = Math.abs(top);
                    int absNum = Math.abs(num);

                    if (absTop == absNum) {
                        // both removed
                        st.remove(st.size() - 1);
                        alive = false;
                    }
                    else if (absTop > absNum) {
                        // top survives, num dies
                        alive = false;
                    }
                    else {
                        // num survives, pop top and continue
                        st.remove(st.size() - 1);
                    }

                } else {
                    break; // same sign → no interaction
                }
            }

            if (alive) {
                st.add(num);
            }
        }

        return st;
    }
}