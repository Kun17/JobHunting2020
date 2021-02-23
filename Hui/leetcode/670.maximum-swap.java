/*
 * @lc app=leetcode id=670 lang=java
 *
 * [670] Maximum Swap
 */

// @lc code=start
class Solution {
    public int maximumSwap(int num) {
        int swapi = -1;
        int swapj = -1;
        StringBuilder s = new StringBuilder();
        s.append(num);
        int max = s.length() - 1;
        for (int i = s.length() - 2; i >= 0; i--) {
            // System.out.println(s.charAt(i) + " " + s.charAt(max));
            if (s.charAt(i) < s.charAt(max)) {
                swapi = i;
                swapj = max;
            }
            if (s.charAt(i) > s.charAt(max)) {
                max = i;
            }
        }
        // System.out.println(swapi);
        if (swapi == -1) {
            return num;
        }

        char c = s.charAt(swapi);
        s.setCharAt(swapi, s.charAt(swapj));
        s.setCharAt(swapj, c);
        return new Integer(s.toString());
    }
}
// @lc code=end

