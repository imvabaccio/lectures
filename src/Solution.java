import java.util.HashMap;

class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hm.put(c, 1 + hm.getOrDefault(c, 0));
        }

        boolean oddValueTaken = false;
        for (int count : hm.values()) {
            if (count % 2 == 0) {
                result += count;
            } else {
                if (oddValueTaken) {
                    result += count - 1;
                } else {
                    result += count;
                    oddValueTaken = true;
                }
            }
        }

        return result;
    }
}