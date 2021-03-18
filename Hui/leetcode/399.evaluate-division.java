/*
 * @lc app=leetcode id=399 lang=java
 *
 * [399] Evaluate Division
 */

// @lc code=start
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, String> parent = new HashMap<>();
        Map<String, Double> dist = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String e1 = equations.get(i).get(0);
            String e2 = equations.get(i).get(1);
            String root1 = find(parent, dist, e1);
            String root2 = find(parent, dist, e2);

            parent.put(root1, root2);
            dist.put(root1, findDist(parent, dist, e2) * values[i] / findDist(parent, dist, e1));
        }
        // System.out.println(parent);
        // System.out.println(dist);
        double[] ret = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String e1 = queries.get(i).get(0);
            String e2 = queries.get(i).get(1);
            if (!parent.containsKey(e1) || !parent.containsKey(e2)) {
                ret[i] = -1.0;
                continue;
            }
            String root1 = find(parent, dist, e1);
            String root2 = find(parent, dist, e2);
            if (!root1.equals(root2)) {
                ret[i] = -1.0;
                continue;
            }

            ret[i] = findDist(parent, dist, e1) / findDist(parent, dist, e2);
        }
        return ret;
        
    }

    public String find(Map<String, String> parent, Map<String, Double> dist, String target) {
        if (!parent.containsKey(target)) {
            parent.put(target, target);
            dist.put(target, 1.0);
        }

        while (!parent.get(target).equals(target)) {
            target = parent.get(target);
        }
        return target;
    }

    public double findDist(Map<String, String> parent, Map<String, Double> dist, String target) {
        double ret = 1.0;
        while (!parent.get(target).equals(target)) {
            ret *= dist.get(target);
            target = parent.get(target);
        }
                // System.out.println(target + " " + ret);

        return ret;
    }
    /*
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
    */
}
// @lc code=end

