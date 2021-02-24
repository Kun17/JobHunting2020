/*
 * @lc app=leetcode id=386 lang=java
 *
 * [386] Lexicographical Numbers
 */

// @lc code=start
class Solution {
    // time: O(n)
    // space: O(logn) depth at most logn (cur * 10) until get to n
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ret = new ArrayList<>();
        traverse(1, n, ret);
        return ret;
    }

    public void traverse(int cur, int n, List<Integer> ret) {
        if (cur > n) return;
        ret.add(cur);
        traverse(cur * 10, n, ret);
        if (cur % 10 != 9) traverse(cur + 1, n, ret);
    }
}
// @lc code=end

