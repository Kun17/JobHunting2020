import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Solution {
    // time complexity: O(V^2)
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
        
        boolean[] inTree = new boolean[n];
        int v = k - 1;
        while(!inTree[v]){
            inTree[v] = true;
            if(graph.containsKey(v)){
                for(int[] edge: graph.get(v)){
                    if(dst[edge[0]] < 0) dst[edge[0]] = dst[v] + edge[1];
                    else dst[edge[0]] = Math.min(dst[edge[0]], edge[1] + dst[v]);                                           
                }
            }

            int min = -1;
            for(int i = 0; i < n; i++){
                if(!inTree[i]){
                    if(min < 0 && dst[i] >= 0) {min = dst[i]; v = i;}
                    else if(dst[i] >= 0 && dst[i] < min) {
                        min = dst[i];
                        v = i;
                    }
                }
            }
        }

        Arrays.sort(dst);
        if(dst[0] < 0) return -1;
        return dst[n-1];
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        int[][] times = new int[][]{{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;
        System.out.println(s.networkDelayTime(times, n, k));
    }
}