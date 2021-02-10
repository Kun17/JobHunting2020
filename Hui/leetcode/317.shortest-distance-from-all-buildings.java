class Solution {
    public int shortestDistance(int[][] grid) {
        Map<Integer, Integer> dist = new HashMap<Integer, Integer>();
        Set<Integer> invalid = new HashSet<Integer>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    dist.put(flat(i, j, grid[0].length), 0);
                }
            }
        }
        // System.out.println(dist);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    // System.out.println("----------------");
                    helper(grid, i, j, dist, invalid);
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int pos: dist.keySet()) {
            if (invalid.contains(pos)) {
                continue;
            }
            if (min > dist.get(pos)) {
                min = dist.get(pos);
            }
        }
        
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        
        return min;
    }
    
    public void helper(int[][] grid, int r, int c, Map<Integer, Integer> dist, Set<Integer> invalid) {
        Set<Integer> visited = new HashSet<Integer>();
        int n = grid[0].length;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(flat(r, c, n));
        // visited.add(flat(r, c, n));
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int distance = 0;
        // int count = 0;
        boolean first = true;
        while (queue.size() > 0) {
            int size = queue.size();
            while (size > 0) {
                size--;
                int pos = queue.poll();
                if (first || dist.containsKey(pos)) {
                    if (!first) {
                        // System.out.println(pos);
                        dist.put(pos, dist.get(pos) + distance);
                    }
                    first = false;
                    int curR = original(pos, n)[0];
                    int curC = original(pos, n)[1];
                    for (int[] dir: dirs) {
                        int nextR = curR + dir[0];
                        int nextC = curC + dir[1];
                        int nextPos = flat(nextR, nextC, n);
                        if (nextR == -1 || nextR == grid.length || nextC == -1 || nextC == grid[0].length) {
                            continue;
                        }
                        if (grid[nextR][nextC] != 0 || visited.contains(nextPos)) {
                            continue;
                        }
                        
                        queue.add(nextPos);
                        visited.add(nextPos);
                    }
                }
            }
            distance++;
        }
        
        for (int pos: dist.keySet()) {
            if (!visited.contains(pos)) {
                invalid.add(pos);
            }
        }
    }
    
    public int flat(int i, int j, int n) {
        return i * n + j;
    }
    
    public int[] original(int i, int n) {
        return new int[]{i / n, i % n};
    }
}
