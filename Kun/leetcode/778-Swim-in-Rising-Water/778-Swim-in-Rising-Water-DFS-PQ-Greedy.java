// Time complexity: N^2*logN
// space complexity: N^2
import java.util.PriorityQueue;
import java.util.Set;
import java.util.HashSet;
class Solution2 {
    int res = 0;
    int n = 0;
    public int swimInWater(int[][] grid) {
        n = grid.length;
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        PriorityQueue<Integer> PQ = new PriorityQueue<>((x,y) -> grid[x/n][x%n] - grid[y/n][y%n]);
        Set<Integer> seen = new HashSet<Integer>();
        PQ.add(0);
        while(!PQ.isEmpty()){
            int cur = PQ.poll();
            int i = cur/n;
            int j = cur%n;
            res = Math.max(grid[i][j], res);
            if(i == n-1 && j == n-1) return res;
            for(int[] dir: dirs){
                int newI = i+dir[0];
                int newJ = j+dir[1];
                int next = newI * n + newJ;
                if(newI >= 0 && newI < n && newJ >= 0 && newJ < n && !seen.contains(next)){
                    PQ.add(next);
                    seen.add(next);
                }
            }
        }
        return -1;
    }

    public static void main(String[] Args){
        Solution2 s = new Solution2();
        int[][] grid = new int[][]{
            {0,2},
            {1,3}
        };
        System.out.println(s.swimInWater(grid));
    }
}