import java.util.Queue;
import java.util.LinkedList;

// This is a BFS problem not a DFS problem, because every minute, we find out all
// newly rotted oranges and contaminates its surrounding oranges
// when no Oranges are left that is the longest time
// time complexity would be O(n^2). space complexity would be the same
class Solution {
    int maxTime = 0;
    int dep, wid;
    public int orangesRotting(int[][] grid) {
        dep = grid.length;
        wid = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < dep; i++){
            for(int j = 0; j < wid; j++){
                if(grid[i][j] == 2) q.add(new int[]{i, j});
            }
        }
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cur = q.poll();
                int curX = cur[0];
                int curY = cur[1];
                for(int[] dir: dirs){
                    int nextX = curX + dir[0];
                    int nextY = curY + dir[1];
                    if(nextX >= 0 && nextX < dep && nextY >= 0 && nextY < wid && grid[nextX][nextY] == 1){
                        q.add(new int[]{nextX, nextY});
                        grid[nextX][nextY] = 2;
                    }
                }
            }
            maxTime++;
        }
        if(maxTime > 0) maxTime--;

        for(int i = 0; i < dep; i++){
            for(int j = 0; j < wid; j++){
                if(grid[i][j] == 1) return -1;
            }
        }        
        return maxTime;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        int[][] grid = new int[][]{
            {2,1,1},{1,1,0},{0,1,1}
        };
        System.out.println(s.orangesRotting(grid));
    }
}