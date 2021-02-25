class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for (int[] edge: edges) {
            int root1 = find(parent, edge[0]);
            int root2 = find(parent, edge[1]);
            if (root1 == root2) return false;
            parent[root1] = root2;
        }
        
        
        return edges.length == n - 1;
    }
    
    public int find(int[] parent, int target) {
        while (parent[target] != target) {
            parent[target] = parent[parent[target]];
            target = parent[target];
        }
        return target;
    }
}
