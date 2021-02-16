/*
 * @lc app=leetcode id=496 lang=java
 *
 * [496] Next Greater Element I
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Stack<Integer> stk = new Stack<Integer>();
        for(int i = 0; i < nums2.length; i++) {
            while(stk.size() > 0 && stk.peek() < nums2[i]) {
                map.put(stk.peek(), nums2[i]);
                stk.pop();
            }

            stk.push(nums2[i]);
        }

        int[] ret = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            if(map.containsKey(nums1[i])) {
                ret[i] = map.get(nums1[i]);
            } else {
                ret[i] = -1;
            }
        }

        return ret;
    }
}
// @lc code=end

