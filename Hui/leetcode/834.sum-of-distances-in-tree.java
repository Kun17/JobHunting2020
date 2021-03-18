/*
 * @lc app=leetcode id=834 lang=java
 *
 * [834] Sum of Distances in Tree
 */

// @lc code=start
class Solution {
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        List<List<Integer>> adjacent = new ArrayList<>();
        int[] dists = new int[N];
        int[] counts = new int[N];
        for (int i = 0; i < N; i++) {
            adjacent.add(new ArrayList<>());
        }
        for (int[] e: edges) {
            adjacent.get(e[0]).add(e[1]);
            adjacent.get(e[1]).add(e[0]);
        }
        calcCount(0, -1, adjacent, counts);
        calcSubtree(0, -1, adjacent, dists, counts);
        calcParent(0, -1, 0, adjacent, dists, counts);

        return dists;
    }
    public int calcCount(int node, int parent, List<List<Integer>> adjacent, int[] counts) {
        int count = 1;
        for (int child: adjacent.get(node)) {
            if (child == parent) continue;
            count += calcCount(child, node, adjacent, counts);
        }
        counts[node] = count;
        return count;
    }
    public int calcSubtree(int node, int parent, List<List<Integer>> adjacent, int[] dists, int[] counts) {
        int dist = 0;
        for (int child: adjacent.get(node)) {
            if (child == parent) continue;
            dist += calcSubtree(child, node, adjacent, dists, counts);
            dist += counts[child];
        }

        dists[node] = dist;
        return dist;
    }

    public void calcParent(int node, int parent, int parentDist, List<List<Integer>> adjacent, int[] dists, int[] counts) {
        dists[node] += parentDist;
        for (int child: adjacent.get(node)) {
            if (child == parent) continue;
            int nextDist = dists[node] - dists[child] - counts[child] + counts[0] - counts[child];
            calcParent(child, node, nextDist, adjacent, dists, counts);
        }
    }
}
// @lc code=end

