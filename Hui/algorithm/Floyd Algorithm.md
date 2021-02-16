# Floyd Algorithm

[Floyd](https://www.cs.rochester.edu/u/nelson/courses/csc_173/graphs/apsp.html)

The algorithm find the shortest path of all pairs of nodes in a graph.

`pair i, j` at `k ` interation: `dp(i, j)` is the value of the shortest path allowing pass nodes `0, 1, 2 ..., k`. Thus, if we take `kth` node in consideration, we need to compare the new path weight passing `k` and without passing `k`.

`dp(i, j)` already the shortest path from `i` to `j` without passing `k` ( and only vertex with an id less than `k`)

new value = `dp(i, k) + dp(k, j)` if there is a path `i -> k` and `k -> j` by checking `dp[i][k] != -1 && dp[k][j] != -1`

if there is no path passing `k` from `i` to `j` , then do not update `dp(i, j)` 

```java
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
```

