class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] adj = new int[n][n];
        for (int[] edge: edges) {
            adj[edge[0]][edge[1]] = edge[2]; 
            adj[edge[1]][edge[0]] = edge[2]; 
        }
        
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adj[i][j] > 0) {
                    dp[i][j] = adj[i][j];
                } else if (i != j) {
                    dp[i][j] = -1;
                }
            }
        }
        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(dp[i][k] != -1 && dp[k][j] != -1) {
                        if (dp[i][j] == -1) {
                            dp[i][j] = dp[i][k] + dp[k][j];
                        } else {
                            dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                        }
                    }
                }
            }
        }
        
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.println("(" + i + ", " + j + ") " + dp[i][j]);
        //     }
        // } 
        
        int min = Integer.MAX_VALUE;
        int ret = -1;
        for (int city = 0; city < n; city++) {
            int temp = 0;
            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (city == neighbor) continue;
                if (dp[city][neighbor] != -1 && dp[city][neighbor] <= distanceThreshold) {
                    temp++;
                }
            }
            if (min >= temp) {
                min = temp;
                ret = city;
            }
        }
        
        return ret;        
    }
}
