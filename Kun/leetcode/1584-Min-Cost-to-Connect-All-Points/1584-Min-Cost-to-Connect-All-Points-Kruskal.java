import java.util.PriorityQueue;

class Solution2 {
    int[] parents;
    int[] rank;
    int[][] points;
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        this.points = points;
        int res = 0;
        parents = new int[n];
        for(int i = 0; i < n; i++){
            parents[i] = i;
        }
        int[][] edge = new int[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> (edge[x[0]][x[1]] - edge[y[0]][y[1]]));
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                edge[i][j] = weight(i, j);
                pq.add(new int[]{i, j});
            }
        }
        rank = new int[n];
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            if(find(x) == find(y)) continue;
            res += edge[x][y];
            union(x, y);
        }
        return res;
    }

    private int weight(int i, int j){
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }

    int find(int i){
        int root = i;
        while(parents[root] != root){
            root = parents[root];
        }
        int child = i;
        while(parents[child] != root){
            int parent = parents[child];
            parents[child] = root;
            child = parent;
        }
        return root;
    }

    // x -> y
    void union(int x, int y){
        if(find(x) == find(y)) return;
        if(rank[x] > rank[y]){
            int temp = x;
            x = y;
            y = temp;
        }
        int rootX = find(x);
        parents[rootX] = find(y);
        if(rank[x] == rank[y]) rank[y]++;
    }
    public static void main(String[] Args){
        Solution2 s = new Solution2();
        int[][] points = new int[][]{
            {2,-3},{-17,-8},{13,8},{-17,-15},
        };
        System.out.println(s.minCostConnectPoints(points));
    }
}