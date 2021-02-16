class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        int len = edges.length;
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n; j++){
                dist[i][j] = -1;
            }
        }
        for(int i = 0; i < len; i++){
            int src = edges[i][0];
            int dst = edges[i][1];
            int wt = edges[i][2];
            dist[src][dst] = dist[dst][src] = wt;
        }
        
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(dist[i][k] > 0 && dist[k][j] > 0){
                        if(dist[i][j] > 0) {
                            dist[i][j] = Math.min(dist[i][k]+dist[k][j], dist[i][j]);
                        } else {
                            dist[i][j] = dist[i][k]+dist[k][j];
                        }
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(i != j && dist[i][j] > 0 && dist[i][j] <= distanceThreshold){
                    count++;
                }
            }
            if(count <= min){
                min = count;
                res = i;
            }
        }

        return res;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        int[][] edges = new int[][]{{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        int distanceThreshold = 4;
        System.out.println(s.findTheCity(4, edges, distanceThreshold));
    }
}