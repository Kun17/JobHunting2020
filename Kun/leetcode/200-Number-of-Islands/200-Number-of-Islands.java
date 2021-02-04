
import java.util.Deque;
import java.util.Queue;

import java.util.ArrayDeque;

import java.util.LinkedList;

class Solution {
    class pos {
        int i, j;
        pos(int i, int j){this.i = i; this.j = j;}
    }
    char[][] grid;
    boolean[][] hitMap;
    int res = 0;
    int depth;
    int width;
    public int numIslands(char[][] grid) {
        // Let's use recursion 1st
        if(grid == null || grid.length == 0) return 0;
        this.grid = grid;
        this.depth = grid.length;
        this.width = grid[0].length;
        this.hitMap = new boolean[depth][width];
        for(int i = 0; i < depth; i++){
            for(int j = 0; j < width; j++){
                //if(hitMap[i][j]) continue;
                if(grid[i][j] == '1') {dfs_recursion(i, j);res++;}
            }
        }
        return res;
    }

    void dfs_recursion(int i, int j){
        if (i >= depth || i < 0 || j < 0 || j >= width || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs_recursion(i+1, j);
        dfs_recursion(i-1, j);
        dfs_recursion(i, j-1);
        dfs_recursion(i, j+1);
    }

    void dfs_traverse(int i, int j){
        Deque<pos> stack = new ArrayDeque<>();
        stack.push(new pos(i, j));
        hitMap[i][j] = true;
        while(!stack.isEmpty()){
            pos curPos = stack.poll();
            int curI = curPos.i;
            int curJ = curPos.j;
            if(curI+1 < depth && grid[curI+1][curJ]=='1' && !hitMap[curI+1][curJ]){
                stack.push(new pos(curI+1, curJ));
                hitMap[curI+1][curJ] = true;
            }
            if(curI-1 >= 0 && grid[curI-1][curJ]=='1'&& !hitMap[curI-1][curJ]){
                stack.push(new pos(curI-1, curJ));
                hitMap[curI-1][curJ] = true;
            }
            if(curJ+1 < width && grid[curI][curJ+1]=='1'&& !hitMap[curI][curJ+1]){
                stack.push(new pos(curI, curJ+1));
                hitMap[curI][curJ+1] = true;
            }
            if(curJ-1 >= 0 && grid[curI][curJ-1]=='1'&& !hitMap[curI][curJ-1]){
                stack.push(new pos(curI, curJ-1));
                hitMap[curI][curJ-1] = true;
            }
        }
        res++;
    }

    class UnionFind{
        int count;
        int[] parent;
        int[] rank;

        UnionFind(char[][] grid){
            int depth = grid.length;
            int width = grid[0].length;
            this.rank = new int[depth*width];
            this.parent = new int[depth*width];
            for (int i = 0; i < depth; i++){
                for(int j = 0; j < width; j++){
                    if (grid[i][j] == '1'){
                        parent[i * width + j] = i*width + j;
                        count++;
                    }
                    rank[i * width + j] = 0;
                } 
            }
        }

        int find(int i){
            int root = i;
            while(parent[root] != root){
                root = parent[root];
            }
            while(parent[i] != i){
                int p = parent[i];
                parent[i] = root;
                i = p;
            }
            return root;
        }

        void union(int i, int j){
            i = find(i);
            j = find(j);
            if(i == j) return;
            
            if(rank[i] > rank[j]){
                int temp = i;
                i = j;
                j = temp;
            }

            parent[i] = j;
            if(rank[i] == rank[j]) rank[j]++;
            count--;
        }
    }

    public int numIslands_unionFind(char[][] grid) {
        // Let's use recursion 1st
        if(grid == null || grid.length == 0) return 0;
        depth = grid.length;
        width = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for(int i = 0; i < depth; i++){
            for(int j = 0; j < width; j++){
                //if(hitMap[i][j]) continue;
                if(grid[i][j] == '1') {
                    if(i+1 < depth && grid[i+1][j] == '1') uf.union(i*width+j, (i+1)*width+j);
                    if(i-1 >= 0 && grid[i-1][j] == '1') uf.union(i*width+j, (i-1)*width+j);
                    if(j+1 < width && grid[i][j+1] == '1') uf.union(i*width+j, i*width+j+1);
                    if(j-1 >= 0 && grid[i][j-1] == '1') uf.union(i*width+j, i*width+j-1);
                }
            }
        }
        return uf.count;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        char[][] grid = new char[][]{
            {'1','1','1','1','1','1'},
            {'1','0','0','0','0','1'},
            {'1','0','1','1','0','1'},
            {'1','0','0','0','0','1'},
            {'1','1','1','1','1','1'},
        };
        System.out.println(s.numIslands_unionFind(grid));
    }
}