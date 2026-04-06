import java.util.*;

class Solution {
    public static void print_divisors(int n) {
        
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                arr.add(i);

                if (i != n / i) {
                    arr.add(n / i);
                }
            }
        }

        Collections.sort(arr);

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}