/*
 * @lc app=leetcode id=1039 lang=java
 *
 * [1039] Minimum Score Triangulation of Polygon
 */

// @lc code=start
class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];

        for (int d = 2; d < n; d++) {
            for (int i = 0; i + d < n; i++) {
                int j = i + d;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + values[i] * values[k] * values[j]);
                }
            }
        }
        return dp[0][n - 1];
    }

    /*
    public int minScoreTriangulation(int[] values) {
        List<Integer> list = new ArrayList<>();
        for (int v: values) {
            list.add(v);
        }
        Map<String, Integer> visited = new HashMap<>();
        return divide(list, visited);
    }

    public int divide(List<Integer> values, Map<String, Integer> visited) {
        if (values.size() < 3) return -1;
        if (values.size() == 3) return values.get(0) * values.get(1) * values.get(2);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.size(); i++) {
            sb.append(values.get(i) + "-");
        }
        if (visited.containsKey(sb.toString())) return visited.get(sb.toString());
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < values.size(); i++) {
            sb.append(values.get(i) + "-");
            for (int j = i + 2; j < values.size(); j++) {
                if (i == 0 && j == values.size() - 1) continue;
                List<Integer> list1 = new ArrayList<>(values.subList(i, j + 1));
                List<Integer> list2 = new ArrayList<>(values.subList(j, values.size()));
                list2.addAll(values.subList(0, i + 1));
                int tmp1 = divide(list1, visited);
                if (tmp1 == -1) continue;
                int tmp2 = divide(list2, visited);
                if (tmp2 == -1) continue;
                ret = Math.min(ret, tmp1 + tmp2);

            }
        }
        visited.put(sb.toString(), ret);
        return ret;
    }
    */
    
}
// @lc code=end

