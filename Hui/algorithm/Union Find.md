# Union Find

### Basic

Basic use is to find the cycle in the graph.

[Leetcode 684](https://leetcode.com/problems/redundant-connection/) / [Leetcode 261](https://leetcode.com/problems/graph-valid-tree/)

Detect the edge that causes the cycle in the graph

```java
class Solution {
    /*
    Time: O(N a(N)) approximately equal to O(N)
    Space: O(N)
    */
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        int[] parent = new int[n + 1];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for(int[] edge : edges) {
            int root1 = find(parent, edge[0]);
            int root2 = find(parent, edge[1]);

            if(root1 == root2) {
                return edge;
            }

            parent[root1] = parent[root2];
        }

        return null;
    }

    public int find(int[] parent, int target) {
        while(parent[target] != target) {
            parent[target] = parent[parent[target]];
            target = parent[target];
        }
        return target;
    }
}
```



### Find Number of Connected Component

Use union find to solve number of island ii [Leetcode 305](https://leetcode.com/problems/number-of-islands-ii/). Set newly added island as a new island, and check 4 directions one by one to find the group id of each component. Reduce `count` by 1 if the component is connected the current newly added island. 

```java
class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] parent = new int[m * n];
        Arrays.fill(parent, -1);
        
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        List<Integer> ret = new ArrayList<Integer>();
        int count = 0;
        for(int[] pos: positions) {
            int r = pos[0];
            int c = pos[1];
            int target = n * r + c;
            
            if(parent[target] != -1) {
                ret.add(count);
                continue;
            }
            
            count++;
            parent[target] = target;
            
            for(int[] dir: dirs) {
                int nextRow = r + dir[0];
                int nextCol = c + dir[1];
                
                int root = -1;
                if(nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n) {
                    root = find(parent, n * nextRow + nextCol);
                }
                
                if(root != -1 && root != target) {
                    count--;
                    parent[root] = target;
                }
            }
          
            ret.add(count);
        }
        
        return ret;
    }
    
    public int find(int[] parent, int target) {
        if(parent[target] == -1) {
            return -1;
        }
        
        while(parent[target] != target) {
            parent[target] = parent[parent[target]];
            target = parent[target];
        }
        
        return target;
    }
}
```



### Minimum Spanning Tree

One usage of the Union Find is to find the MST.

Sort all the edges by weight. Greedly pick the minimum edge each time. Skip the edge that causes the cycle. Use Union Find to check the group id of the ends of the edge. Add this edge to result if two ends having different `root`values.

Time: O(ElogE + E a(V)) approximately to O(ElogE) which is basically cause by the sorting

Space: O(V)

```java
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
```