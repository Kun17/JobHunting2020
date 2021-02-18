import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.HashMap;

class Solution2 {
    // time complexity: O((E+V)logV)
    // space complexity: O(E+V)
    Map<Integer, List<int[]>> graph;
    public int networkDelayTime(int[][] times, int n, int k) {
        graph = new HashMap<>();
        int[] dst = new int[n];
        Arrays.fill(dst, -1);
        dst[k-1] = 0;
        for(int[] time: times){
            List<int[]> edges = graph.getOrDefault(time[0]-1, new ArrayList<>());
            edges.add(new int[]{time[1]-1, time[2]});
            graph.put(time[0]-1, edges);
        }
        

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((x,y) -> (x[1] - y[1]));
        minHeap.offer(new int[]{k-1, 0});
        boolean[] inTree = new boolean[n];
        int v;
        while(!minHeap.isEmpty()){
            v = minHeap.poll()[0];
            inTree[v] = true;
            if(graph.containsKey(v)){
                for(int[] edge: graph.get(v)){
                    if(!inTree[edge[0]]){
                        if(dst[edge[0]] < 0) {dst[edge[0]] = dst[v] + edge[1];minHeap.offer(new int[]{edge[0], dst[edge[0]]});}
                        else if(dst[edge[0]] > edge[1] + dst[v]){
                            dst[edge[0]] = edge[1] + dst[v];
                            minHeap.offer(new int[]{edge[0], dst[edge[0]]});    
                        }
                    }                                       
                }
            }

            if(!minHeap.isEmpty()) v = minHeap.peek()[0];
        }

        Arrays.sort(dst);
        if(dst[0] < 0) return -1;
        return dst[n-1];
    }

    public static void main(String[] Args){
        Solution2 s = new Solution2();
        int[][] times = new int[][]{{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;
        System.out.println(s.networkDelayTime(times, n, k));
    }
}