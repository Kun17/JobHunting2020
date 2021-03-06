import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class Solution4 {
    // time complexity: O((E+V)logV)
    // space complexity: O(E+V)
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> g = new HashMap<>();
        for(int[] edge: times){
            int sc = edge[0], dst = edge[1], wt = edge[2];
            g.computeIfAbsent(sc, l -> new ArrayList<>()).add(new int[]{dst, wt});
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        dist[k] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y) -> (dist[x] - dist[y]));
        pq.add(k);
        Set<Integer> visited = new HashSet<>();
        while(!pq.isEmpty()){
            int cur = pq.poll();
            visited.add(cur);
            if(visited.size() == n) break;
            for(int[] next: g.getOrDefault(cur, new ArrayList<>())){
                int dest = next[0];
                int wt = next[1];
                if((dist[dest] == -1 || dist[dest] > wt + dist[cur]) && !visited.contains(dest)){
                    dist[dest] = wt + dist[cur];
                    pq.add(dest);
                }
            }
        }
        dist[0] = 0;
        Arrays.sort(dist);
        if(dist[0] == -1) return -1;
        return dist[n];
    }

    public static void main(String[] Args){
        Solution4 s = new Solution4();
        int[][] times = new int[][]{{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;
        System.out.println(s.networkDelayTime(times, n, k));
    }
}