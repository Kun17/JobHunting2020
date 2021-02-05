import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;

import java.util.List;

class Solution3 {
    List<Integer> sortedGraph;
    Map<Integer, List<Integer>> graph;
    boolean[] checked;
    Set<Integer> dependCourse = new HashSet<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        sortedGraph = new LinkedList<>();
        graph = new HashMap<>();
        for(int[] r: prerequisites){
            List<Integer> adjs = graph.getOrDefault(r[1], new ArrayList<>());
            adjs.add(r[0]);
            graph.put(r[1], adjs);
            dependCourse.add(r[0]);
            dependCourse.add(r[1]);
        }
        checked = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            boolean[] visited = new boolean[numCourses];
            boolean isCyclic = dfsSort(i, visited);
            if(isCyclic) return new int[0];
        }

        return sortedGraph.stream().mapToInt(x->x).toArray();
    }

    boolean dfsSort(int i, boolean[] visited){
        if(checked[i]) return false;
        if(visited[i]) return true;
        visited[i] = true;

        if(!dependCourse.contains(i)) {
            sortedGraph.add(i);
            return false;
        }

        for(Integer next: graph.getOrDefault(i, new ArrayList<>())){
            if(dfsSort(next, visited)) return true;
        }
        visited[i] = false;
        checked[i] = true;
        sortedGraph.add(0, i);
        return false;
    }

    public static void main(String[] Args){
        Solution3 s = new Solution3();
        int[][] prerequisites = new int[][]{{4,3},{3,2}, {3,1}};
        int[] res = s.findOrder(5, prerequisites);
        for(int r: res){
            System.out.println(r);
        }
    }
}