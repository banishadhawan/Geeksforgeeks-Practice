class Solution {
    String removeSpaces(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                result += s.charAt(i);
            }
        }
        return result;
    }
}