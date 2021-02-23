/*
 * @lc app=leetcode id=1514 lang=java
 *
 * [1514] Path with Maximum Probability
 */

// @lc code=start
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<double[]>> map = new HashMap<Integer, List<double[]>>();
        for (int i = 0; i < edges.length; i++) {
            List<double[]> list1 = map.getOrDefault(edges[i][0], new ArrayList<double[]>());
            list1.add(new double[]{(double) edges[i][1], succProb[i]});
            map.put(edges[i][0], list1);

            List<double[]> list2 = map.getOrDefault(edges[i][1], new ArrayList<double[]>());
            list2.add(new double[]{(double) edges[i][0], succProb[i]});
            map.put(edges[i][1], list);
        }

        PriorityQueue<double[]> heap = new PriorityQueue<double[]>((a, b) -> Double.compare(b[1], a[1]));
        Map<Integer, Double> p = new HashMap<Integer, Double>();
        Set<Integer> visited = new HashSet<Integer>();
        heap.add(new double[]{(double) start, 1d});
        p.put(start, 1d);

        while (heap.size() > 0) {
            double[] cur = heap.poll();
            int node = (int) cur[0];
            if (visited.contains(node)) continue;
            visited.add(node);
            if (node == end) {
                return cur[1];
            }
            if (map.get(node) == null) continue;

            for (double[] next: map.get(node)) {
                int nextNode = (int) next[0];
                if (!p.containsKey(nextNode)) {
                    p.put(nextNode, cur[1] * next[1]);
                    heap.add(new double[]{next[0], cur[1] * next[1]});
                } else if (p.get(nextNode) < cur[1] * next[1]) {
                    heap.add(new double[]{next[0], cur[1] * next[1]});
                    p.put(nextNode, cur[1] * next[1]);
                }
            }
        }

        return 0d;
    }
}
// @lc code=end

