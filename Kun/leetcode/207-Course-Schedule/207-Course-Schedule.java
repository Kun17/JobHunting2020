import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;

class Solution {
    boolean[] visited;
    Map<Integer, List<Integer>> nextMap;
    public boolean canFinish_bt(int numCourses, int[][] prerequisites) {
        this.visited = new boolean[numCourses];
        this.nextMap = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++){
           List<Integer> nexts = nextMap.getOrDefault(prerequisites[i][1], new ArrayList<>());
           nexts.add(prerequisites[i][0]);
           nextMap.put(prerequisites[i][1], nexts);
        }

        for(int i = 0; i < numCourses; i++){
            if(isCyclic(i)) return false;
        }
        return true;
    }

    boolean isCyclic(int i){
        if(visited[i]) return true;
        if(!nextMap.containsKey(i)) return false;
        
        visited[i] = true;
        for(int next: nextMap.get(i)){
            if(isCyclic(next)) return true;
        }
        visited[i] = false;
        return false;
    }

    public boolean canFinish_dfs(int numCourses, int[][] prerequisites) {
        this.visited = new boolean[numCourses];
        this.nextMap = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++){
           List<Integer> nexts = nextMap.getOrDefault(prerequisites[i][1], new ArrayList<>());
           nexts.add(prerequisites[i][0]);
           nextMap.put(prerequisites[i][1], nexts);
        }


        for(int i = 0; i < numCourses; i++){
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(i);
            boolean[] recStack = new boolean[numCourses];
            recStack[i] = true;
            while(!stack.isEmpty()){
                Integer cur = stack.poll();
                for (int next: nextMap.getOrDefault(cur, new ArrayList<Integer>())){
                    if(recStack[next]) return false;
                    stack.push(next);
                    recStack[next] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        int[][] prerequisites = new int[][]{{1,4},{2,4},{3,1},{3,2}};
        System.out.println(s.canFinish_dfs(5, prerequisites));
    }
}