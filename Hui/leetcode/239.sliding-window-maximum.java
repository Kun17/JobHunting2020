/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<Integer>();
        
        for (int i = 0; i < k; i++) {
            while (deque.size() > 0 && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
        }
        int[] ret = new int[nums.length - k + 1];
        ret[0] = deque.peekFirst();
        int cur = 1;
        for (int i = k; i < nums.length; i++) {
            if (nums[i - k] == deque.peekFirst()) {
                deque.pollFirst();
            }
            while (deque.size() > 0 && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
            ret[cur++] = deque.peekFirst();
        }

        return ret;
    }
}
// @lc code=end

