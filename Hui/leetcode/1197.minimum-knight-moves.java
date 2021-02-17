class Solution {
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        int[][] dirs = new int[][]{{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
        
        Set<String> visited = new HashSet<String>();
        Queue<int[]> queue = new LinkedList<int[]>();
        
        queue.add(new int[]{0, 0});
        visited.add("0-0");
        
        int dist = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[0] == x && cur[1] == y) {
                    return dist;
                }
                
                for (int[] dir: dirs) {
                    int[] next = new int[]{cur[0] + dir[0], cur[1] + dir[1]};
                    String key = next[0] + "-" + next[1];
                    if (!visited.contains(key) && Math.abs(next[0] - x) <= x + 2 && Math.abs(next[1] - y) <= y + 2) {
                        queue.add(next);
                        visited.add(key);
                    }
                }
            }
            
            dist++;
        }
        
        return -1;
    }
}
