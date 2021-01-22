import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Sliding window, [i, j)
        // Starting from i = 0, j = 0
        // Increment j, adding pair[char, pos] into map
        // Check if s.charAt(j) is already in the map
        // if not, increase anwser to j - i + 1
        // if so, increase i to the i pos in map + 1
        // if returned s.charAt(j) pos from map is less than i, we should ignore it
        // of returned s.charAt(j) pos from map is bigger than i, we ack it and update its pos in map
        // then set anwser to Math.max(j - i + 1, anwser)
        Map<Character, Integer> valPosMap = new HashMap<>();
        int anwser = 0;
        for (int i = 0, j = 0; j < s.length(); j++){
            Character jChar = s.charAt(j);
            Integer existPos = valPosMap.get(jChar);
            if (existPos != null && existPos >= i) {
                i = existPos + 1;
            }
            anwser = Math.max(j - i + 1, anwser);
            valPosMap.put(jChar, j);
        }
        return anwser;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.lengthOfLongestSubstring("pwwkew");
        System.out.println(res);
    }
}