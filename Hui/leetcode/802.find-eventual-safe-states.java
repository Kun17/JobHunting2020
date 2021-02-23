/*
 * @lc app=leetcode id=802 lang=java
 *
 * [802] Find Eventual Safe States
 */

// @lc code=start
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        List<Integer> ret = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                helper(graph, i, visited);
            }

            if (visited[i] == 1) {
                ret.add(i);
            }
        }

        return ret;
    }

    public int helper(int[][] graph, int cur, int[] visited) {
        if (visited[cur] != 0) {
            return visited[cur];
        }

        if (graph[cur].length == 0) {
            visited[cur] = 1;
            return visited[cur];
        }

        visited[cur] = -1;
        for (int i = 0; i < graph[cur].length; i++) {
            if (helper(graph, graph[cur][i], visited) == -1) {
                visited[cur] = -1;
                return -1;
            }
        }
        visited[cur] = 1;
        return visited[cur];
    }
    //[[1, 2],[0], []]
}
// @lc code=end

