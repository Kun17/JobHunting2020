/*
 * @lc app=leetcode id=241 lang=java
 *
 * [241] Different Ways to Add Parentheses
 */

// @lc code=start
class Solution {
    Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    public List<Integer> diffWaysToCompute(String input) {
        if(map.containsKey(input)) {
            return map.get(input);
        }

        List<Integer> ret = new ArrayList<Integer>();
        int num = 0;
        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*') {
                List<Integer> l1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> l2 = diffWaysToCompute(input.substring(i + 1, input.length()));
                for(int n1: l1) {
                    for(int n2: l2) {
                        switch(ch) {
                            case '+':
                                ret.add(n1 + n2);
                                break;
                            case '-':
                                ret.add(n1 - n2);
                                break;
                            default:
                                ret.add(n1 * n2);
                        }
                    }
                }
            } else {
                num *= 10;
                num += (int) (ch - '0');
            }
        }

        if(ret.size() == 0) {
            ret.add(num);
        }

        return ret;
    }
}
// @lc code=end

