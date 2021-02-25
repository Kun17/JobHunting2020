/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            int ia = 0, ib = 0;
            if (i >= 0) {
                ia = a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                ib = b.charAt(j) - '0';
                j--;
            }
            int sum = ia + ib + carry;
            if (sum == 0) {
                sb.append(0);
                carry = 0;
            } else if (sum == 1) {
                sb.append(1);
                carry = 0;
            } else if (sum == 2) {
                sb.append(0);
                carry = 1;
            } else {
                sb.append(1);
                carry = 1;
            }
        }
        if (carry == 1) sb.append(1);

        return sb.reverse().toString();
    }
}
// @lc code=end

