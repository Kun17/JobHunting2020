// Time complexity: 3^(n^2)
// space complexity: n^2
import java.util.PriorityQueue;
class Solution4 {
    int n;
    int[] parents;
    int[] rank;
    boolean[] visited;
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int swimInWater(int[][] grid) {
        n = grid.length;
        parents = new int[n*n];
        rank = new int[n*n];
        visited = new boolean[n*n];
        for(int i = 0; i < n*n; i++){
            parents[i] = i;
        }
        // 0(value) 1(position)
        PriorityQueue<int[]> PQ = new PriorityQueue<>((x,y)->(x[0]-y[0]));
        for(int i= 0; i < n;i++){
            for(int j = 0; j < n; j++){
                PQ.add(new int[]{grid[i][j], i*n+j});
            }
        }

        int last = n*n -1;
        while(!PQ.isEmpty()){
            int[] cur = PQ.poll();
            if(visited[cur[1]]) continue;
            visited[cur[1]] = true;
            int i = cur[1]/n;
            int j = cur[1]%n;
            for(int[] dir: dirs){
                int newI = i + dir[0];
                int newJ = j + dir[1];
                int next = newI*n + newJ;
                if(newI >= 0 && newI < n && newJ >= 0 && newJ < n && visited[next]){
                    union(cur[1], next);
                }
            }
            if(find(last) == find(0)) return cur[0];
        }
        return -1;
    }

    private int find(int child){
        int i = child;
        while(parents[i] != i){
            i = parents[i];
        }
        int root = i;
        while(parents[child] != root){
            int parent = parents[child];
            parents[child] = root;
            child = parent;
        }
        return root;
    }

    // i -> j
    private void union(int i, int j){
        if(find(i) == find(j)) return;
        if(rank[i] > rank[j]){
            int temp = i;
            i = j;
            j = temp;
        }
        parents[find(i)] = find(j);
        if(rank[i] == rank[j]) rank[j]++;
    }

    public static void main(String[] Args){
        Solution4 s = new Solution4();
        int[][] grid = new int[][]{
            {0,1,2,3,4},
            {24,23,22,21,5},
            {12,13,14,15,16},
            {11,17,18,19,20},
            {10,9,8,7,6}
        };
        System.out.println(s.swimInWater(grid));
    }
}