/*
 * @lc app=leetcode id=282 lang=java
 *
 * [282] Expression Add Operators
 */

// @lc code=start
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ret = new ArrayList<String>();
        helper(num, 0, 0, 0, target, "", ret);

        return ret;
    }

    public void helper(String num, int pos, long sum, long prev, int target, String str, List<String> ret) {
        if (pos == num.length()) {
            if (sum == target) {
                ret.add(str);
            }
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i > pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                helper(num, i + 1, sum + cur, cur, target, str + cur, ret);
            } else {
                helper(num, i + 1, sum + cur, cur, target, str + '+' + cur, ret);
                helper(num, i + 1, sum - cur, -cur, target, str + '-' + cur, ret);
                helper(num, i + 1, sum - prev + prev * cur, prev * cur, target, str + '*' + cur, ret);
            }

        }


    }
}
// @lc code=end

