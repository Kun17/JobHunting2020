/*
 * @lc app=leetcode id=797 lang=java
 *
 * [797] All Paths From Source to Target
 */

// @lc code=start
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> subRet = new ArrayList<Integer>();
        subRet.add(0);

        dfs(0, visited, graph, subRet, ret);

        return ret;
    }

    public void dfs(int cur, boolean[] visited, int[][] graph, List<Integer> tmp, List<List<Integer>> ret) {
        if(visited[cur]) {
            return;
        }

        if(cur == graph.length - 1) {
            ret.add(new ArrayList<Integer>(tmp));
            return;
        }

        visited[cur] = true;
        for(int next: graph[cur]) {
            tmp.add(next);
            dfs(next, visited, graph, tmp, ret);
            tmp.remove(tmp.size() - 1);
        }
        visited[cur] = false;
    }
}
// @lc code=end

