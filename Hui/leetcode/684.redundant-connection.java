/*
 * @lc app=leetcode id=684 lang=java
 *
 * [684] Redundant Connection
 */

// @lc code=start
class Solution {
    /*
    Time: O(N a(N)) approximately equal to O(N)
    Space: O(N)
    */
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        int[] parent = new int[n + 1];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for(int[] edge : edges) {
            int root1 = find(parent, edge[0]);
            int root2 = find(parent, edge[1]);

            if(root1 == root2) {
                return edge;
            }

            parent[root1] = parent[root2];
        }

        return null;
    }

    public int find(int[] parent, int target) {
        while(parent[target] != target) {
            parent[target] = parent[parent[target]];
            target = parent[target];
        }
        return target;
    }
}
// @lc code=end

