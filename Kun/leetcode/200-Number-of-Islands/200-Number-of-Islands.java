
import java.util.Deque;
import java.util.Queue;
import java.util.ArrayDeque;

import java.util.LinkedList;

class Solution {
    class pos {
        int i, j;
        pos(int i, int j){this.i = i; this.j = j;}
    }
    public int numIslands(char[][] grid) {
        int res = 0;
        int depth = grid.length, width = grid[0].length;
        boolean[][] hitMap = new boolean[depth][width];
        int i, j;
        Deque<pos> stack = new ArrayDeque<>();
        stack.push(new pos(0,0));
        hitMap[0][0] = true;
        while(!stack.isEmpty()){
            // if 0, spread untill reaching to 1
            // if 1, reach all the 1
            pos curPos = stack.poll();
            i = curPos.i;
            j = curPos.j;
            //if(hitMap[i][j]) continue;
            //hitMap[i][j] = true;
            if (grid[i][j] == '0'){
                if(i+1 < depth && !hitMap[i+1][j]){
                    stack.push(new pos(i+1, j));
                    hitMap[i+1][j] = true;
                    if(grid[i+1][j] == 1) continue;
                }
                if(i-1>=0 && !hitMap[i-1][j]){
                    stack.push(new pos(i-1, j));
                    hitMap[i-1][j] = true;
                    if(grid[i-1][j] == 1) continue;
                }
                if(j+1 < width && !hitMap[i][j+1]){
                    stack.push(new pos(i, j+1));
                    hitMap[i][j+1] = true;
                    if(grid[i][j+1] == 1) continue;
                }
                if(j-1>=0 && !hitMap[i][j-1]){
                    stack.push(new pos(i, j-1));
                    hitMap[i][j-1] = true;
                    if(grid[i][j-1] == 1) continue;
                }
            } else {
                // hit all the 1
                Queue<pos> oneQ = new LinkedList<>();
                oneQ.add(curPos);
                while(!oneQ.isEmpty()){
                    pos curOnePos = oneQ.poll();
                    int onei = curOnePos.i;
                    int onej = curOnePos.j;
                    if(onei+1 < depth && !hitMap[onei+1][onej]){
                        if (grid[onei+1][onej] == '1') oneQ.add(new pos(onei+1, onej));
                        else stack.push(new pos(onei+1, onej));
                        hitMap[onei+1][onej] = true;
                    }
                    if(onei-1 >=0 && !hitMap[onei-1][onej]){
                        if (grid[onei-1][onej] == '1') oneQ.add(new pos(onei-1, onej));
                        else stack.push(new pos(onei-1, onej));
                        hitMap[onei-1][onej] = true;
                    }
                    if(onej+1 < width && !hitMap[onei][onej+1]){
                        if (grid[onei][onej+1] == '1') oneQ.add(new pos(onei, onej+1));
                        else stack.push(new pos(onei, onej+1));
                        hitMap[onei][onej+1] = true;
                    }
                    if(onej-1 >= 0 && !hitMap[onei][onej-1]){
                        if (grid[onei][onej-1] == '1') oneQ.add(new pos(onei, onej-1));
                        else stack.push(new pos(onei, onej-1));
                        hitMap[onei][onej-1] = true;
                    }
                }
                res++;
            }
        }
        return res;
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
        System.out.println(s.numIslands(grid));
    }
}