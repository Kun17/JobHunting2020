/*
 * @lc app=leetcode id=85 lang=java
 *
 * [85] Maximal Rectangle
 */

// @lc code=start
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int[] h = new int[matrix[0].length];
        int ret = 0;
        for(int r = 0; r < matrix.length; r++) {
            for(int c = 0; c < matrix[0].length; c++) {
                if(matrix[r][c] == '1') {
                    h[c] = h[c] + 1;
                } else {
                    h[c] = 0;
                }
            }

            ret = Math.max(ret, findMaxRec(h));
        }

        return ret;
    }

    public int findMaxRec(int[] h) {
        Stack<Integer> stk = new Stack<Integer>();
        int[] leftFirstSmaller = new int[h.length];
        // iterator from right to left, find the first smaller to the left
        for(int i = h.length - 1; i >= 0; i--) {
            while(stk.size() > 0 && h[stk.peek()] > h[i]) {
                leftFirstSmaller[stk.pop()] = i;
            }
            stk.push(i);
        }
        while(stk.size() > 0) {
            leftFirstSmaller[stk.pop()] = -1;
        }

        int maxArea = 0;
        // iterator from left to right, find the first smaller to the right
        for(int i = 0; i < h.length; i++) {
            while(stk.size() > 0 && h[stk.peek()] > h[i]) {
                int cur = stk.pop();
                int area = (i - leftFirstSmaller[cur] - 1) * h[cur];
                maxArea = Math.max(maxArea, area);
            }
            stk.push(i);
        }
        // System.out.println(stk.size());
        while(stk.size() > 0) {
            int cur = stk.pop();
            // System.out.println(cur + " leftFirstSmaller[0] = " + leftFirstSmaller[cur]);
            int area = (h.length - leftFirstSmaller[cur] - 1) * h[cur];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
// @lc code=end

