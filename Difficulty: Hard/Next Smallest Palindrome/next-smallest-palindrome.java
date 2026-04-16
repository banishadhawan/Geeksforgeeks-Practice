class Solution {
    static int[] nextPalindrome(int[] num) {
        int n = num.length;
        boolean all9 = true;
        for (int x : num) {
            if (x != 9) {
                all9 = false;
                break;
            }
        }
        if (all9) {
            int[] res = new int[n + 1];
            res[0] = 1;
            res[n] = 1;
            return res;
        }

        int[] res = num.clone();

        int i = 0, j = n - 1;
        while (i < j) {
            res[j] = res[i];
            i++;
            j--;
        }
        boolean greater = false;
        for (int k = 0; k < n; k++) {
            if (res[k] > num[k]) {
                greater = true;
                break;
            } else if (res[k] < num[k]) {
                break;
            }
        }

        if (greater) return res;

        
        int carry = 1;
        int mid = n / 2;

        if (n % 2 == 1) {
            res[mid] += carry;
            carry = res[mid] / 10;
            res[mid] %= 10;
            i = mid - 1;
            j = mid + 1;
        } else {
            i = mid - 1;
            j = mid;
        }
        while (i >= 0 && carry > 0) {
            res[i] += carry;
            carry = res[i] / 10;
            res[i] %= 10;

            res[j] = res[i]; 
            i--;
            j++;
        }
        while (i >= 0) {
            res[j] = res[i];
            i--;
            j++;
        }

        return res;
    }
}