/*
 * @lc app=leetcode id=1697 lang=java
 *
 * [1697] Checking Existence of Edge Length Limited Paths
 */

// @lc code=start
class Solution {
    // class Query {
    //     int idx;
    //     int[] query;
    //     public Query(int idx, int[] query) {
    //         this.idx = idx;
    //         this.query = query;
    //     }
    // }

    /*
    Time O(QlogQ + ElogE + Q + E) = O(QlogQ + ElogE)
    Space O(Q + N)
    */
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries){
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);

        Map<int[], Integer> idxMap = new HashMap<int[], Integer>();
        for(int i = 0; i < queries.length; i++) {
            idxMap.put(queries[i], i);
        }
        Arrays.sort(queries, (a, b) -> a[2] - b[2]);

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        boolean[] ret = new boolean[queries.length];
        int ei = 0;
        for (int i = 0; i < queries.length; i++) {
            while (ei < edgeList.length && edgeList[ei][2] < queries[i][2]) {
                // int root1 = find(parent, edgeList[ei][0]);
                parent[find(parent, edgeList[ei][0])] = find(parent, edgeList[ei][1]);

                ei++;
            }
            // System.out.println("ei=" + ei);
            int root1 = find(parent, queries[i][0]);
            int root2 = find(parent, queries[i][1]);
            // System.out.println("q=" + i + " root1=" + root1 + " root2=" + root2);

            ret[idxMap.get(queries[i])] = (root1 == root2);
        }

        return ret;
    }

    public int find(int[] parent, int target) {
        while(parent[target] != target) {
            parent[target] = parent[parent[target]];
            target = parent[target];
        }
        return target;
    }
 /*
 5\n[[0,1,10],[1,2,5],[2,3,9],[3,4,13]]\n[[0,4,14],[1,4,13]]
 */
    //     int[][] adj = new int[n][n];
    //     for (int[] edge: edgeList) {
    //         int u = edge[0];
    //         int v = edge[1];
    //         if (adj[u][v] == 0) {
    //             adj[u][v] = edge[2];
    //             adj[v][u] = edge[2];
    //         } else {
    //             adj[u][v] = Math.min(adj[u][v], edge[2]);
    //             adj[v][u] = adj[u][v];
    //         }
    //     }


    // }

    // public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
    //     int[][] adj = new int[n][n];
    //     for (int[] edge: edgeList) {
    //         int u = edge[0];
    //         int v = edge[1];
    //         if (adj[u][v] == 0) {
    //             adj[u][v] = edge[2];
    //             adj[v][u] = edge[2];
    //         } else {
    //             adj[u][v] = Math.min(adj[u][v], edge[2]);
    //             adj[v][u] = adj[u][v];
    //         }
    //     }
    //     // for (int i = 0; i < n; i++) {
    //     //     for (int j = 0; j < n; j++) {
    //     //         System.out.println("(" + i + ", " + j + ") " + adj[i][j]);
    //     //     }
    //     // }

    //     int[][] dist = floyd(adj, n);
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < n; j++) {
    //             System.out.println("(" + i + ", " + j + ") " + dist[i][j]);
    //         }
    //     }

    //     boolean[] ret= new boolean[queries.length];
    //     for (int i = 0; i < queries.length; i++) {
    //         int u = queries[i][0];
    //         int v = queries[i][1];
    //         if(dist[u][v] < queries[i][2]) {
    //             ret[i] = true;
    //         }
    //     }
    //     return ret;
    // }

    // public int[][] floyd(int[][] edge, int n) {
    //     int[][] dp = new int[n][n];
    //     for (int i = 0; i < n; i++) {
    //         for(int j = 0; j < n; j++) {
    //             if (edge[i][j] > 0) {
    //                 dp[i][j] = edge[i][j];
    //             } else if (i != j) {
    //                 dp[i][j] = -1;
    //             }
    //         }
    //     }

    //     for (int k = 0; k < n; k++) {
    //         for (int i = 0; i < n; i++) {
    //             for (int j = 0; j < n; j++) {
    //                 if (dp[k][j] != -1 && dp[i][k] != -1) {
    //                     dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
    //                 }
    //             }
    //         }
    //     }

    //     return dp;
    // }
}
// @lc code=end

