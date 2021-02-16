class Solution {
    public int minimumCost(int N, int[][] connections) {
        int[] parent = new int[N + 1];
        for(int i = 0; i < N; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        int cost = 0;
        int count = 0;
        for(int[] conn: connections) {
            int root1 = find(parent, conn[0]);
            int root2 = find(parent, conn[1]);
            
            // cycle
            if(root1 == root2) {
                continue;
            }
            
            count++;
            cost += conn[2];
            parent[root1] = root2;
        }
        if(count == N - 1) {
            return cost;
        }
        return -1;
    }
    
    public int find(int[] parent, int target) {
        while(parent[target] != target) {
            parent[target] = parent[parent[target]];
            target = parent[target];
        }
        return target;
    }
}
