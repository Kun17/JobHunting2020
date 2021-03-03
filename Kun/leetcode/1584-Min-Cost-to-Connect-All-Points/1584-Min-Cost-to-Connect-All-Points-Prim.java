import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int res = 0;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        Set<Integer> outTreeNodes = new HashSet<>();
        for(int i = 0; i < n; i++){
            outTreeNodes.add(i);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y) -> (dist[x]-dist[y]));
        pq.add(0);
        while(!pq.isEmpty()){
            int cur = pq.poll();
            res += dist[cur];
            outTreeNodes.remove(cur);
            if(outTreeNodes.isEmpty()) break;
            Set<Integer> otLocal = new HashSet<>(outTreeNodes);
            for(int next: otLocal){
                int nw = weight(cur, next, points);
                if(dist[next] > nw){
                    dist[next] = nw;
                    pq.remove(next);
                    pq.add(next);
                }
            }
        }
        return res;
    }

    private int weight(int i, int j, int[][] points){
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        int[][] points = new int[][]{
            {0,0},{2,2},{3,10},{5,2},{7,0},
        };
        System.out.println(s.minCostConnectPoints(points));
    }
}