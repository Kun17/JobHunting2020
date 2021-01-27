/*
 * @lc app=leetcode id=526 lang=java
 *
 * [526] Beautiful Arrangement
 */

// @lc code=start
class Solution {

    int ret = 0;
    public int countArrangement(int n) {
        int[] visited = new int[n + 1];
        dfs(n, visited, 1);
        return ret;
    }

    public void dfs(int n, int[] visited, int pos) {
        if(pos > n) {
            ret++;
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(visited[i] == 0 && (i % pos == 0 || pos % i == 0)) {
                visited[i] = 1;
                dfs(n, visited, pos + 1);
                visited[i] = 0;            
            }
        }
    }
}
// @lc code=end

