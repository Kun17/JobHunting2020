/*
 * @lc app=leetcode id=785 lang=java
 *
 * [785] Is Graph Bipartite?
 */

// @lc code=start
class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for(int i = 0; i < graph.length; i++) {
            if(color[i] != 0) {
                continue;
            }
            if(!dfs(graph, i, color, 1)) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int[][] graph, int i, int[] colors, int curColor) {
        if(colors[i] != 0) {
            if(colors[i] != curColor) {
                return false;
            }
            return true;
        }

        colors[i] = curColor;
        for(int next : graph[i]) {
            if(!dfs(graph, next, colors, curColor * -1)) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

