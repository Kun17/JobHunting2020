import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Solution3 {
    // time complexity: O(V^2)
    // space complexity: O(V)
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
        
        dfs(k-1, dst);

        Arrays.sort(dst);
        if(dst[0] < 0) return -1;
        return dst[n-1];
    }

    private void dfs(int i, int[] dst){
        if(graph.containsKey(i)){
            for(int[] edge: graph.get(i)){
                if(dst[edge[0]] < 0 || dst[edge[0]] >0 && dst[edge[0]] > edge[1] + dst[i]){
                    dst[edge[0]] = dst[i] + edge[1]; 
                    dfs(edge[0], dst);
                }
            }
        }
    }

    public static void main(String[] Args){
        Solution3 s = new Solution3();
        int[][] times = new int[][]{{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;
        System.out.println(s.networkDelayTime(times, n, k));
    }
}