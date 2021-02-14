/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        // from left to right to find the first smaller element
        Stack<Integer> stk = new Stack<Integer>();
        int[] rightSmaller = new int[heights.length];
        for(int i = 0; i < heights.length; i++) {
            while(stk.size() > 0 && heights[stk.peek()] > heights[i]) {
                rightSmaller[stk.pop()] = i;
            }

            stk.push(i);
        }

        while(stk.size() > 0) {
            rightSmaller[stk.pop()] = heights.length;
        }

        int[] leftSmaller = new int[heights.length];
        for(int i = heights.length - 1; i >= 0; i--) {
            while(stk.size() > 0 && heights[stk.peek()] > heights[i]) {
                leftSmaller[stk.pop()] = i;
            }
            
            stk.push(i);
        }

        while(stk.size() > 0) {
            leftSmaller[stk.pop()] = -1;
        }

        int maxArea = 0;
        for(int i = 0; i < heights.length; i++) {
            // System.out.println("height = " + heights[i] + " right = " + rightSmaller[i] + " left = " + leftSmaller[i] + " ");
            int len = rightSmaller[i] - leftSmaller[i] - 1;
            int area = len * heights[i];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
// @lc code=end

