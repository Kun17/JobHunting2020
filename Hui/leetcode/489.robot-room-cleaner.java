/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    public void cleanRoom(Robot robot) {
        step(robot, 0, 0, 0, new HashSet<String>());
    }
    
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};    
    public void step(Robot robot, int x, int y, int dir, Set<String> visited) {
        robot.clean();
        visited.add(x + " " + y);
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dirs[(dir + i) % 4][0];
            int ny = y + dirs[(dir + i) % 4][1];
            
            if (!visited.contains(nx + " " + ny) && robot.move()) {
                step(robot, nx, ny, (dir + i) % 4, visited);
            }
            robot.turnRight();
        }
        
        robot.turnLeft();
        robot.turnLeft();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
    
}
