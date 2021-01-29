/*
 * @lc app=leetcode id=886 lang=java
 *
 * [886] Possible Bipartition
 */

// @lc code=start
class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<Integer>[] edges = new ArrayList[N + 1];
        for(int[] d : dislikes) {
            if(edges[d[0]] == null) {
                edges[d[0]] = new ArrayList<Integer>();
            }
            edges[d[0]].add(d[1]);
            if(edges[d[1]] == null) {
                edges[d[1]] = new ArrayList<Integer>();
            }
            edges[d[1]].add(d[0]);
        }

        int[] colors = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            if(colors[i] == 0) {
                boolean valid = partition(edges, i, 1, colors);
                if(!valid) return false;
            }
        }

        return true;
    }

    public boolean partition(List<Integer>[] edges, int cur, int color, int[] colors) {
        if(colors[cur] != 0) {
            if(colors[cur] != color) {
                return false;
            }
            return true;
        }

        colors[cur] = color;
        if(edges[cur] != null) {
            for(int next : edges[cur]) {
                if(!partition(edges, next, color * -1, colors)) {
                    return false;
                }
            }
        }

        return true;
    }
}
// @lc code=end

