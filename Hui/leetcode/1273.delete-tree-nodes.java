class Solution {
    int count = 0;
    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        Map<Integer, List<Integer>> edges = new HashMap<>();
        for (int i = 0; i < nodes; i++) edges.put(i, new ArrayList<Integer>());
        int root = -1;
        for (int i = 0; i < nodes; i++) {
            if (parent[i] == -1){
                root = i;
                continue;
            }
            List<Integer> list = edges.get(parent[i]);
            list.add(i);
            edges.put(parent[i], list);
        }
        
        return dfs(root, edges, value)[1];
    }
    
    public int[] dfs(int i, Map<Integer, List<Integer>> edges, int[] value) {
        int sum = value[i];
        int count = 1;
        for (int next: edges.getOrDefault(i, new ArrayList<Integer>())) {
            int[] subtree = dfs(next, edges, value);
            sum+= subtree[0];
            count += subtree[1];
        }
        
        if (sum == 0) return new int[]{0, 0};
        
        return new int[]{sum, count};
    }
}
