import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.LinkedList;

class Solution {
    Map<Integer, List<int[]>> graph;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // Let's go with dijkstra 1st
        
        // build the graph
        graph = new HashMap<>();
        for(int[] flight: flights){
            if(!graph.containsKey(flight[0])){
                graph.put(flight[0], new ArrayList<>());
            }
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        // init distArr to record distance to the src
        int[] distArr = new int[n];
        Arrays.fill(distArr, -1);
        distArr[src] = 0;
        int[] stepArr = new int[n];
        Arrays.fill(stepArr, 101);
        stepArr[src] = 0;

        // Build the heap
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((x,y) -> (x[1] - y[1]));
        // src distance-to-the-tree step
        minHeap.offer(new int[]{src, 0, 0});
        int[] v;
        while(!minHeap.isEmpty()){
            v = minHeap.poll();
            int start = v[0];
            int steps = v[2];
            int cost = v[1];
            if(start == dst) return cost;
            if(steps == K + 1) continue;
            for(int[] edge: graph.getOrDefault(v[0], new ArrayList<>())){
                if(distArr[edge[0]] < 0 || (distArr[edge[0]] > 0 && edge[1] + cost < distArr[edge[0]])){
                    distArr[edge[0]] = edge[1] + cost;
                    stepArr[edge[0]] = steps + 1;
                    minHeap.offer(new int[]{edge[0], distArr[edge[0]], v[2] + 1});
                } else if(steps + 1 < stepArr[edge[0]]){
                    stepArr[edge[0]] = steps + 1;
                    minHeap.offer(new int[]{edge[0], edge[1] + cost, stepArr[edge[0]]});
                }
            }
        }

        return distArr[dst];
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        int[][] flights = new int[][]{{0,3,3},{3,4,3},{4,1,3},{0,5,1},{5,1,100},{0,6,2},{6,1,100},{0,7,1},{7,8,1},{8,9,1},{9,1,1},{1,10,1},{10,2,1},{1,2,100}};
        int[][] flights2 = new int[][]{{0,3,3},{3,4,3},{4,1,3},{0,5,1},{0,6,2},{0,7,1},{7,8,1},{8,9,1},{9,1,1},{1,10,1},{10,2,1}};
        System.out.println(s.findCheapestPrice(11, flights, 0, 2, 4)); 
    }
}