/*
 * @lc app=leetcode id=310 lang=java
 *
 * [310] Minimum Height Trees
 */

// @lc code=start
class Solution {
    /*
    Time: O(N)
    Space: O(N)
    */
    List<Integer> longestPath = new ArrayList<Integer>();
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(edges.length == 0) {
            List<Integer> ret = new ArrayList<Integer>();
            ret.add(0);
            return ret;
        }
        List<Integer>[] elist = new ArrayList[n];
        for(int i = 0; i < elist.length; i++) {
            elist[i] = new ArrayList<Integer>();
        }
        for(int[] e : edges) {
            int v = e[0];
            int u = e[1];
            elist[v].add(u);
            elist[u].add(v);
        }

        int[] dist = new int[n];
        int[] prev = new int[n];
        findLongestPath(0, dist, prev, elist);
        int v = 0;
        for(int i = 0; i < n; i++) {
            if(dist[v] < dist[i]) {
                v = i;
            }
        }

        dist[v] = 0;
        prev[v] = -1;
        findLongestPath(v, dist, prev, elist);
        int u = v;
        for(int i = 0; i < n; i++) {
            if(dist[u] < dist[i]) {
                u = i;
            }
        }
        List<Integer> path = new ArrayList<Integer>();
        path.add(u);
        while(prev[u] != -1) {
            path.add(prev[u]);
            u = prev[u];
        }
        // System.out.println(path);
        List<Integer> ret = new ArrayList<Integer>();
        int len = path.size();
        ret.add(path.get(len / 2));

        if(len % 2 == 0) {
            ret.add(path.get(len / 2 - 1));
        }

        return ret;
    }

    public void findLongestPath(int start, int[] dist, int[] prev, List<Integer>[] elist) {
        Queue<Integer> q = new LinkedList<Integer>();
        Set<Integer> visited = new HashSet<Integer>();

        q.add(start);
        visited.add(start);

        while(q.size() > 0) {
            int cur = q.poll();
            for(int next : elist[cur]) {
                if(!visited.contains(next)) {
                    prev[next] = cur;
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                    visited.add(next);
                }
            }
        }
    }
 //6\n[[3,0],[3,1],[3,2],[3,4],[5,4]]
    
}
// @lc code=end

