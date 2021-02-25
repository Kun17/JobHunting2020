/*
 * @lc app=leetcode id=850 lang=java
 *
 * [850] Rectangle Area II
 */

// @lc code=start
class Solution {
    public int rectangleArea(int[][] rectangles) {
        Set<Integer> setx = new HashSet<>();
        Set<Integer> sety = new HashSet<>();

        List<Integer> xval = new ArrayList<>();
        List<Integer> yval = new ArrayList<>();
        
        for (int[] rec: rectangles) {
            if (!setx.contains(rec[0])) {
                xval.add(rec[0]);
                setx.add(rec[0]);
            }
            if (!setx.contains(rec[2])) {
                xval.add(rec[2]);
                setx.add(rec[2]);
            }
            if (!sety.contains(rec[1])) {
                yval.add(rec[1]);
                sety.add(rec[1]);
            }
            if (!sety.contains(rec[3])) {
                yval.add(rec[3]);
                sety.add(rec[3]);
            }
        }

        Collections.sort(xval);
        Collections.sort(yval);

        Map<Integer, Integer> xmap = new HashMap<>();
        Map<Integer, Integer> ymap = new HashMap<>();

        for (int i = 0; i < xval.size(); i++) {
            xmap.put(xval.get(i), i);
        }
        for (int i = 0; i < yval.size(); i++) {
            ymap.put(yval.get(i), i);
        }

        int[][] grid = new int[xval.size() - 1][yval.size() - 1];
        for (int[] rec: rectangles) {
            for (int i = xmap.get(rec[0]); i < xmap.get(rec[2]); i++) {
                for (int j = ymap.get(rec[1]); j < ymap.get(rec[3]); j++) {
                    grid[i][j] = 1;
                }
            }
        }

        long ret = 0;
        long MOD = 1000000007;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ret = ret + ((long) (xval.get(i + 1) - xval.get(i)) % MOD * (long) (yval.get(j + 1) - yval.get(j)) % MOD) % MOD;
                    ret = ret % MOD;
                }
            }
        }

        return (int) ret;
    }
}
// @lc code=end

