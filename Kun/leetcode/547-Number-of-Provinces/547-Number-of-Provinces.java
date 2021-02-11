import java.util.Set;
import java.util.HashSet;

class Solution {
    int[] parents;
    int[] ranks;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parents = new int[n];
        ranks = new int[n];
        
        //init the parents arr, every city's root is itself's position
        //init the rank arr, every city's initial rank should zero
        for(int i = 0; i < parents.length; i++){
            parents[i] = i;
            ranks[i] = 0;
        }

        for(int i = 0; i < n ; i++){
            for(int j = i + 1; j < n ; j++){
                if(isConnected[i][j] == 1) {
                    System.out.printf("i: %d j: %d\n", i, j);
                    union(i, j);
                }
            }
        }

        for(int i = 0; i < n; i++){
            find(i);
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(parents[i]);
        }
        return set.size();
    }

    // we need to compress the tree as well
    int find(int child){
        if(parents[child] != child) {
            parents[child] = find(parents[child]);
        }
        return parents[child];
    }

    int union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB) return rootA;
        if(ranks[rootA] > ranks[rootB]){
            int temp = rootA;
            rootA = rootB;
            rootB = temp;        
        }

        parents[rootA] = rootB;
        if(ranks[rootA] == ranks[rootB]) ranks[rootB]++;
        return rootB;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        int[][] data = new int[][]{
            {1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
            {0,1,0,1,0,0,0,0,0,0,0,0,0,1,0},
            {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,0,1,0,0,0,1,0,0,0,1,0,0,0},
            {0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
            {0,0,0,1,0,0,0,1,1,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
            {1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},
            {0,0,0,1,0,0,0,0,0,0,0,1,0,0,0},
            {0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},
            {0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}
        };
        System.out.println(s.findCircleNum(data));
    }
}