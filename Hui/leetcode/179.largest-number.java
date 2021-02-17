/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(str, new Comparator<String> () {
            public int compare(String a, String b) {
                return (a + b).compareTo(b + a);
            }
        });

        if (str[str.length - 1].charAt(0) == '0') return "0";
        
        StringBuilder sb = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            sb.append(str[i]);
        }

        return sb.toString();
    }

}
// @lc code=end

