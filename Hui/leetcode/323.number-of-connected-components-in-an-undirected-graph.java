class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n i++) {
            parent[i] = i;
        }
        int count = n;
        for (int[] edge: edges) {
            int root1 = find(parent, edge[0]);
            int root2 = find(parent, edge[1]);
            if (root1 != root2) {
                count = count - 1;
                parent[root1] = root2;
            }
        }
        return count;
    }
    
    public int find(int[] parent, int target) {
        while (parent[target] != target) {
            parent[target] = parent[parent[target]];
            target = parent[target];
        }
        
        return target;
    }
}
