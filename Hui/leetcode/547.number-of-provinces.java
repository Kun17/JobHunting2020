/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Number of Provinces
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n];

        int ret = 0;
        for(int i = 0; i < n; i++) {
            if(visited[i] == 0) {
                ret++;
                findConnected(isConnected, i, visited);
            }
        }

        return ret;
    }

    public void findConnected(int[][] edges, int cur, int[] visited) {
        if(visited[cur] == 1) {
            return;
        }

        visited[cur] = 1;
        for(int next = 0; next < edges.length; next++) {
            if(edges[cur][next] == 1) {
                findConnected(edges, next, visited);
            }
        }
    }
}
// @lc code=end

