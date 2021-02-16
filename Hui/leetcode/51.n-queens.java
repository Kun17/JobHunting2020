/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new ArrayList<List<String>>();
        int[] seen = new int[n];
        Arrays.fill(seen, -1);
        helper(n, seen, new ArrayList<String>(), ret);
        return ret;
    }

    public void helper(int n, int[] seen, List<String> tmp, List<List<String>> ret) {
        if(tmp.size() == n) {
            ret.add(new ArrayList<String>(tmp));
            return;
        }

        StringBuilder line = new StringBuilder();
        for(int i = 0; i < n; i++) {
            line.append('.');
        }
        int row = tmp.size();
        for(int col = 0; col < n; col++) {
            if(seen[col] != -1) {
                continue;
            }
            boolean valid = true;
            for(int dist = 1; dist <= row; dist++) {
                if(col - dist >= 0 && seen[col - dist] == row - dist) {
                    valid = false;
                    break;
                }
                if(col + dist < n && seen[col + dist] == row - dist) {
                    valid = false;
                    break;
                }
            }
            if(!valid) continue;
            seen[col] = row;
            line.setCharAt(col, 'Q');
            tmp.add(line.toString());
            helper(n, seen, tmp, ret);
            tmp.remove(tmp.size() - 1);
            line.setCharAt(col, '.');
            seen[col] = -1;
        }
    }
}
// @lc code=end

