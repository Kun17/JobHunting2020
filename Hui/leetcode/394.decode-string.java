/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */

// @lc code=start
class Solution {
    int idx = 0;
    public String decodeString(String s) {
        StringBuilder ret = new StringBuilder();
        int num = 0;
        while(idx < s.length()) {
            char ch = s.charAt(idx);
            if(ch >= 'a' && ch <= 'z') {
                ret.append(ch);
            } else if(ch >= '0' && ch <= '9') {
                num *= 10;
                num += (int) (ch - '0');
            } else if(ch == '[') {
                idx++;
                String substr = decodeString(s);
                for(int i = 0; i < num; i++) {
                    ret.append(substr);
                }
                num = 0;
            } else {
                return new String(ret);
            }
            idx++;
        }
        return new String(ret);
    }
    // ""100[leetcode]""
    // public String decode(String s) {

    // }
}
// @lc code=end

