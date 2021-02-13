import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Deque;
import java.util.ArrayList;

class Solution {
    boolean[] visited;
    boolean[] checked;
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
        this.checked = new boolean[numCourses];
        this.nextMap = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++){
           List<Integer> nexts = nextMap.getOrDefault(prerequisites[i][1], new ArrayList<>());
           nexts.add(prerequisites[i][0]);
           nextMap.put(prerequisites[i][1], nexts);
        }

        for(int i = 0; i < numCourses; i++){
            if(isCyclic_dfs(i)) return false;
        }
        return true;
    }

    boolean isCyclic_dfs(int i){
        if(checked[i]) return false;
        if(visited[i]) return true;
        if(!nextMap.containsKey(i)) {
            checked[i] = true;
            return false;
        }

        visited[i] = true;
        for(int next: nextMap.get(i)){
            if(isCyclic_dfs(next)) return true;
        }
        visited[i] = false;
        checked[i] = true;
        return false;
    }

    // This is trick because, we only have numbers to interate through, we construct a graph by nodes
    // but also attach each node to its value in a map

    class Node{
        int indegree;
        List<Node> outNodes;
        Node(int i) {this.indegree = i;this.outNodes= new ArrayList<>();}
    }
    Map<Integer, Node> graph;
    public boolean canFinish_khan_graph(int numCourses, int[][] prerequisites) {
        int edgesNum = prerequisites.length;
        this.graph = new HashMap<>();
        for(int[] relation: prerequisites){
            Node precourse = getNode(relation[1]);
            Node course = getNode(relation[0]);
            precourse.outNodes.add(course);
            course.indegree++;
            graph.put(relation[1], precourse);
            graph.put(relation[0], course);
        }

        Deque<Node> S = new LinkedList<>();
        for(Map.Entry<Integer, Node> entry: graph.entrySet()){
            Node curNode = entry.getValue();
            if(curNode.indegree == 0) S.add(curNode);
        }

        int reducedEdge = 0;
        while(!S.isEmpty()){
            Node curNode = S.poll();
            for(Node next: curNode.outNodes){
                next.indegree--;
                reducedEdge++;
                if(next.indegree == 0) {
                    S.add(next);
                }
            }
        }
        
        return reducedEdge == edgesNum;
    }

    private Node getNode(int i){
        if(graph.containsKey(i)) return graph.get(i);
        else {
            Node node = new Node(i);
            graph.put(i, node);
            return node;
        }
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        int[][] prerequisites = new int[][]{{1,4},{2,4},{3,1},{3,2}};
        System.out.println(s.canFinish_dfs(5, prerequisites));
    }
}