/*
 * @lc app=leetcode id=542 lang=java
 *
 * [542] 01 Matrix
 */

// @lc code=start
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<int[]>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int[][] ret=  new int[matrix.length][matrix[0].length];
        int dist = 0;
        int[][] offsets = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(queue.size() > 0) {
            int size = queue.size();
            // System.out.println("==================");
            for(int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if(matrix[cur[0]][cur[1]] == 1 && ret[cur[0]][cur[1]] == 0) {
                    ret[cur[0]][cur[1]] = dist;
                }
                for(int[] offset : offsets) {
                    int[] newPos = new int[]{cur[0] + offset[0], cur[1] + offset[1]};
                    if(newPos[0] == -1 || newPos[0] == matrix.length || newPos[1] == -1 || newPos[1] == matrix[0].length) {
                        continue;
                    }
                    if(matrix[newPos[0]][newPos[1]] == 0) {
                        continue;
                    }
                    if(ret[newPos[0]][newPos[1]] > 0) {
                        continue;
                    }
                    // System.out.println(newPos[0] + " " + newPos[1]);
                    queue.add(newPos);
                }
            }
            dist++;
        }
        // [[0,0,0],[0,1,0],[1,1,1]]
        return ret;
    }
}
// @lc code=end

