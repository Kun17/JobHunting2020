/*
 * @lc app=leetcode id=864 lang=java
 *
 * [864] Shortest Path to Get All Keys
 */

// @lc code=start
class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();

        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '@') {
                    queue.add(new int[]{i, j});
                } else if (grid[i].charAt(j)  <= 'f' && 'a' <= grid[i].charAt(j)) {
                    k++;
                }
            }
        }

        int[] cur = new int[k + 2];
        int[] start = queue.poll();
        cur[0] = start[0];
        cur[1] = start[1];

        queue.add(cur);
        visited.add(getKey(cur));

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int move = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                char ch = grid[cur[0]].charAt(cur[1]);
                if (ch == '#') continue;
                if ('A' <= ch && ch <= 'F' && cur[ch - 'A' + 2] == 0) {
                    // lock but no key
                    continue;
                }
                if ('a' <= ch && ch <= 'f') {
                    // get the key
                    cur[ch - 'a' + 2] = 1;
                } 
                int keys = 0;
                for (int j = 2; j < cur.length; j++) {
                    keys += cur[j];
                }
                if (keys == k) return move;

                for (int[] dir: dirs) {
                    int[] next = new int[k + 2];
                    next[0] = cur[0] + dir[0];
                    next[1] = cur[1] + dir[1];
                    if (next[0] == -1 || next[0] == m || next[1] == -1 || next[1] == n) continue;
                    for (int j = 2; j < k + 2; j++) {
                        next[j] = cur[j];
                    }
                    String visitedKey = getKey(next);
                    if (visited.contains(visitedKey)) continue;
                    queue.add(next);
                    visited.add(visitedKey);
                }
                
            }
            move++;
        }

        return -1;
    }

    public String getKey(int[] cur) {
        StringBuilder sb = new StringBuilder();
        sb.append(cur[0]);
        sb.append("-");
        sb.append(cur[1]);
        sb.append("-");
        for (int i = 2; i < cur.length; i++) {
            sb.append(cur[i]);
        }

        return sb.toString();
    }
}
// @lc code=end

