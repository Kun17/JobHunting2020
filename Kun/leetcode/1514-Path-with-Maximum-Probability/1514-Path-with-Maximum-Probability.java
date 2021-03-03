import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // Let's go wtih dijkstra using heap implementation
        Map<Integer, List<int[]>> g = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            int a = edges[i][0], b = edges[i][1];
            g.computeIfAbsent(a, l -> new ArrayList<>()).add(new int[]{b, i});
            g.computeIfAbsent(b, l -> new ArrayList<>()).add(new int[]{a, i});
        }
        double[] p = new double[n];
        p[start] = 1d;
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y) -> Double.compare(p[y], p[x]));
        pq.offer(start);
        while(!pq.isEmpty()){
            int a = pq.poll();
            if(a == end) return p[end];
            for(int[] next: g.getOrDefault(a, new ArrayList<>())){
                int b = next[0], bIdx = next[1];
                if(p[b] < p[a]*succProb[bIdx]){
                    p[b] = p[a]*succProb[bIdx];
                    pq.offer(b);
                }
            }
        }
        return 0d;
    }
}