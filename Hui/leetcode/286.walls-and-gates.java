class Solution {
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    dfs(i, j, rooms, 0);
                }
            }
        }
    }
    
    public void dfs(int i, int j, int[][] rooms, int dist) {
        if (i == -1 || i == rooms.length || j == -1 || j == rooms[0].length) return;
        
        if (rooms[i][j] < dist) return;        
        rooms[i][j] = dist;
        dfs(i + 1, j, rooms, dist + 1);
        dfs(i, j + 1, rooms, dist + 1);
        dfs(i - 1, j, rooms, dist + 1);
        dfs(i, j - 1, rooms, dist + 1);
    }
}
