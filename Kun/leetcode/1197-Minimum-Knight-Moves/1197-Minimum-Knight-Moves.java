import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Queue;

class Solution {
    private final int[][] DIRECTIONS = new int[][]{{2,-1},{2,1},{1,-2},{1,2},{-1,-2},{-1,2},{-2,-1},{-2,1}};
    public int minKnightMoves(int x, int y) {
        // Go with BFS
        // Let's try BFS recursion 1st
        x= Math.abs(x);
        y= Math.abs(y);

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        q.add(null);

        Set<String> visited = new HashSet<>();
        visited.add("0,0");

        int result = 0;
        while(!q.isEmpty()){
            int[] curPos = q.poll();
            if (curPos == null) {
                result++;
                if(!q.isEmpty()) q.add(null);
                continue;
            }
            int curX = curPos[0];
            int curY = curPos[1];
            if (curX == x && curY == y) return result;
            for(int[] dir: DIRECTIONS){
                int newX = curX + dir[0];
                int newY = curY + dir[1];
                if (!visited.contains(newX + "," + newY) && newX >= -1 && newY >= -1){
                    q.add(new int[]{newX, newY});
                    visited.add(newX + "," + newY);
                }
            }
        }
        return -1;
    }

    public int minKnightMoves_forloop(int x, int y) {
        // Go with BFS
        // Let's try BFS recursion 1st
        x= Math.abs(x);
        y= Math.abs(y);

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});

        Set<String> visited = new HashSet<>();
        visited.add("0,0");

        int result = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] curPos = q.poll();
                int curX = curPos[0];
                int curY = curPos[1];
                if (curX == x && curY == y) return result;
                for(int[] dir: DIRECTIONS){
                    int newX = curX + dir[0];
                    int newY = curY + dir[1];
                    if (!visited.contains(newX + "," + newY) && newX >= -1 && newY >= -1){
                        q.add(new int[]{newX, newY});
                        visited.add(newX + "," + newY);
                    }
                }
            }
            result++;
        }
        return -1;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        System.out.println(s.minKnightMoves(2, 112));
    }
}