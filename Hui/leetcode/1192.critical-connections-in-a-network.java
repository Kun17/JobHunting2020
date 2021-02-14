/*
 * @lc app=leetcode id=1192 lang=java
 *
 * [1192] Critical Connections in a Network
 */

// @lc code=start
class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] dfn = new int[n];
        Arrays.fill(dfn, -1);
        int[] low = new int[n];

        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for(List<Integer> conn: connections) {
            graph[conn.get(1)].add(conn.get(0));
            graph[conn.get(0)].add(conn.get(1));
        }

        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        time = 0;
        helper(0, -1, dfn, low, graph, ret);
        return ret;
    }

    int time;
    public void helper(int cur, int parent, int[] dfn, int[] low, List<Integer>[] graph, List<List<Integer>> ret) {
        low[cur] = time;
        dfn[cur] = time++;
        
        for (int next: graph[cur]) {
            if (dfn[next] == -1) {
                helper(next, cur, dfn, low, graph, ret);
                low[cur] = Math.min(low[cur], low[next]);
                if (low[next] > dfn[cur]) {
                    ret.add(new ArrayList<Integer>(Arrays.asList(cur, next)));
                }
            } else if (next != parent) {
                low[cur] = Math.min(low[cur], dfn[next]);
            }
        }
    }
}
// @lc code=end

