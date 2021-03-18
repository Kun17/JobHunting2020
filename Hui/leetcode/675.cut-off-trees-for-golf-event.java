/*
 * @lc app=leetcode id=675 lang=java
 *
 * [675] Cut Off Trees for Golf Event
 */

// @lc code=start
class Solution {
    class Tree {
        int x, y;
        int height;
        public Tree(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }
    public int cutOffTree(List<List<Integer>> forest) {
        PriorityQueue<Tree> heap = new PriorityQueue<>((a, b) -> a.height - b.height);
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(i).size(); j++) {
                if (forest.get(i).get(j) > 1) {
                    heap.add(new Tree(i, j, forest.get(i).get(j)));
                }
            }
        }
        
        heap.add(new Tree(0, 0, 1));

        int steps = 0;
        while (heap.size() > 1) {
            Tree cur = heap.poll();
            // System.out.println(cur.x + ", " + cur.y + " " + cur.height);
            forest.get(cur.x).set(cur.y, 1);
            // System.out.println(heap.peek().x + "--" + heap.peek().y + " " + heap.peek().height);
            int step = path(cur.x, cur.y, heap.peek().x, heap.peek().y, forest);
            if (step == -1) {
                return -1;
            }
            // System.out.println(step);
            steps += step;
        }

        return steps;
    }

    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int path(int x1, int y1, int x2, int y2, List<List<Integer>> forest) {
        int dist = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[forest.size()][forest.get(0).size()];
        queue.add(new int[]{x1, y1});
        visited[x1][y1] = 1;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[0] == x2 && cur[1] == y2) {
                    return dist;
                }
                for (int[] dir: dirs) {
                    int[] next = new int[]{cur[0] + dir[0], cur[1] + dir[1]};
                    if (next[0] < 0 || next[0] >= forest.size() || next[1] < 0 || next[1] >= forest.get(0).size()) {
                        continue;
                    }
                    if (visited[next[0]][next[1]] == 1 || forest.get(next[0]).get(next[1]) == 0) {
                        continue;
                    }
                    queue.add(next);
                    visited[next[0]][next[1]] = 1;
                }
            }
            dist++;
        }

        return -1;
    }
}
// "[[54581641,64080174,24346381,69107959],[86374198,61363882,68783324,79706116],[668150,92178815,89819108,94701471],[83920491,22724204,46281641,47531096],[89078499,18904913,25462145,60813308]]"
// @lc code=end

