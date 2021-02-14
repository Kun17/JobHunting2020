class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] parent = new int[m * n];
        Arrays.fill(parent, -1);
        
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        List<Integer> ret = new ArrayList<Integer>();
        int count = 0;
        for(int[] pos: positions) {
            int r = pos[0];
            int c = pos[1];
            int target = n * r + c;
            
            if(parent[target] != -1) {
                ret.add(count);
                continue;
            }
            
            count++;
            parent[target] = target;
            
            for(int[] dir: dirs) {
                int nextRow = r + dir[0];
                int nextCol = c + dir[1];
                
                int root = -1;
                if(nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n) {
                    root = find(parent, n * nextRow + nextCol);
                }
                
                if(root != -1 && root != target) {
                    count--;
                    parent[root] = target;
                }
            }
          
            ret.add(count);
        }
        
        return ret;
    }
    
    public int find(int[] parent, int target) {
        if(parent[target] == -1) {
            return -1;
        }
        
        while(parent[target] != target) {
            parent[target] = parent[parent[target]];
            target = parent[target];
        }
        
        return target;
    }
}
