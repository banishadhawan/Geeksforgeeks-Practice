import java.util.*;

class Solution {
    public static String minWindow(String s, String p) {
        
        if (s.length() < p.length()) return "";

        Map<Character, Integer> map = new HashMap<>();

        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int minstart = 0;
        int count = 0;
        Map<Character, Integer> windowFreq = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c,0)+1);
            if (map.containsKey(c) && windowFreq.get(c) <= map.get(c)) {
                count++;
            }

            while (count == p.length()) {

                if (right - start + 1 < minLen) {
                    minLen = right - start + 1;
                    minstart = start;
                }

                char ch = s.charAt(start);
                windowFreq.put(ch, windowFreq.get(ch)-1);

                if (map.containsKey(ch) && windowFreq.get(ch)<map.get(ch)) {
                    count--;
                }

                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minstart, minstart + minLen);
    }
}