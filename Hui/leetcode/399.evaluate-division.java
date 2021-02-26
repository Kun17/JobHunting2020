/*
 * @lc app=leetcode id=399 lang=java
 *
 * [399] Evaluate Division
 */

// @lc code=start
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> e = equations.get(i);
            Map<String, Double> next = map.getOrDefault(e.get(0), new HashMap<>());
            next.put(e.get(1), values[i]);
            map.put(e.get(0), next);
            Map<String, Double> next2 = map.getOrDefault(e.get(1), new HashMap<>());
            next2.put(e.get(0), 1.0 / values[i]);
            map.put(e.get(1), next2);
        }

        double[] ret = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String s = queries.get(i).get(0), e = queries.get(i).get(1);
            if (!map.containsKey(s) || !map.containsKey(e)) {
                ret[i] = -1.0;
            } else {
                Set<String> visited = new HashSet<>();
                ret[i] = dfs(s, e, map, visited);
            }
        }

        return ret;
    }

    public double dfs(String s, String e, Map<String, Map<String, Double>> map, Set<String> visited) {
        if (s.equals(e)) return 1.0;
        if (visited.contains(s)) return -1.0;
        visited.add(s);
        for (String next: map.getOrDefault(s, new HashMap<>()).keySet()) {
            double tmp1 = map.get(s).get(next);
            double tmp2 = dfs(next, e, map, visited);
            if (tmp2 != -1.0) {
                return tmp1 * tmp2;
            }
        } 

        return -1.0;
    }
}
// @lc code=end

