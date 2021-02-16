/*
 * @lc app=leetcode id=621 lang=java
 *
 * [621] Task Scheduler
 */

// @lc code=start
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> taskLen = new HashMap<Character, Integer>();

        int maxLen = 0;
        for(char task: tasks) {
            int len = taskLen.getOrDefault(task, 0) + 1;
            taskLen.put(task, len);
            maxLen = Math.max(maxLen, len);
        }

        Map<Integer, Integer> lenCount = new HashMap<Integer, Integer>();
        int subLen = 0;
        int maxLenCount = 0;
        for(char task: taskLen.keySet()) {
            int len = taskLen.get(task);
            if(len == maxLen) {
                subLen += len - 1;
                maxLenCount++;
            } else {
                subLen += len;
            }
        }

        return Math.max(subLen, (maxLen - 1) * (n + 1)) + maxLenCount;
    }
}
// @lc code=end

