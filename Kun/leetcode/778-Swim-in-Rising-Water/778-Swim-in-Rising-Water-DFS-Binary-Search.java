// Time complexity: N^2*logN
// space complexity: N^2
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
class Solution3 {
    int n = 0;
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int swimInWater(int[][] grid) {
        n = grid.length;        
        int lo = grid[0][0], hi = n * n;
        while(lo < hi){
            int mid = (lo + hi)/2;
            if(isPossible(mid, grid)){
                hi = mid;
            } else {
                lo = mid+ 1;
            }
        }
        return lo;
    }

    private boolean isPossible(int bound, int[][] grid){
        // If word is found in seen, a cycle is detected
        Set<Integer> discovered = new HashSet<Integer>();
        Stack<Integer> stack = new Stack<>();
        discovered.add(0);
        stack.push(0);
        while(!stack.isEmpty()){
            int cur = stack.pop();
            int i = cur/n;
            int j = cur%n;
            if(i == n-1 && j == n-1) return true;
            for(int[] dir: dirs){
                int newI = i + dir[0];
                int newJ = j + dir[1];
                int next = newI * n + newJ;
                if(newI >=0 && newI < n && newJ >=0 && newJ < n && grid[newI][newJ] <= bound && !discovered.contains(next)){
                    stack.add(next);
                    discovered.add(next);
                }
            }
        }
        return false;
    }



    public static void main(String[] Args){
        Solution3 s = new Solution3();
        int[][] grid = new int[][]{
            {0,2},
            {1,3}
        };
        System.out.println(s.swimInWater(grid));
    }
}