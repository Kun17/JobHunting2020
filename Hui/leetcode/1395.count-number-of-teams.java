/*
 * @lc app=leetcode id=1395 lang=java
 *
 * [1395] Count Number of Teams
 */

// @lc code=start
class Solution {
    public int numTeams(int[] rating) {
        TreeSet<Integer> tree = new TreeSet<Integer>();

        int[] leftLess = new int[rating.length];
        int[] leftGreater = new int[rating.length];
        for (int i = 0; i < rating.length; i++) {
            leftLess[i] = tree.headSet(rating[i]).size();
            leftGreater[i] = i - leftLess[i];
            tree.add(rating[i]);
        }

        int[] rightLess = new int[rating.length];
        int[] rightGreater = new int[rating.length];
        tree.clear();
        for (int i = rating.length - 1; i >= 0; i--) {
            rightLess[i] = tree.headSet(rating[i]).size();
            rightGreater[i] = rating.length - 1 - i - rightLess[i];
            tree.add(rating[i]);
        }

        int ret = 0;
        for (int i = 0; i < rating.length; i++) {
            ret += leftLess[i] * rightGreater[i];
            ret += leftGreater[i] * rightLess[i];
        }

        return ret;
    }
}
// @lc code=end

