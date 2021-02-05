import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;

import java.util.List;

class Solution2 {
    class Node {
        int indegree;
        int value;
        List<Integer> outNodes;
        Node(int v){this.indegree = 0; this.value = v; this.outNodes = new ArrayList<>();}
    }
    Map<Integer, Node> Graph;
    List<Node> sortedGraph;
    Set<Integer> dependSet;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // BFS is impossible 
        // Let's try Kahn's algorithm to bring about topologically sorted graph
        this.Graph = new HashMap<>();
        this.dependSet = new HashSet<>();
        sortedGraph = topologicalSort_Kahn(prerequisites);
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(!dependSet.contains(i)) {
                q.add(new Node(i));
                visited[i] = true;
            }
        }

        for(Node n: sortedGraph){
            if(n.indegree == 0) {
                q.add(n);
                visited[n.value] = true;
            }
        }

        int i = 0;
        int[] res = new int[numCourses];
        int count = 0;
        while(!q.isEmpty()){
            Node course = q.poll();
            res[i++] = course.value;
            for(Integer next: course.outNodes){
                if(visited[next]) return new int[]{};
                Node nextNode = Graph.get(next);
                nextNode.indegree--;
                count++;
                if(nextNode.indegree == 0) {
                    q.add(nextNode);
                    visited[next] = true;
                }
            }
        }
        if(count == prerequisites.length) return res;
        return new int[0];
    }

    // Kahn's algorithm
    List<Node> topologicalSort_Kahn(int[][] prerequisites){
        for(int[] relation: prerequisites){
            if(relation.length == 2) insert(relation[1], relation[0]);
        }
        sortedGraph = new ArrayList<>(Graph.values());
        sortedGraph.sort((x, y) -> Integer.compare(x.indegree, y.indegree));
        // sortedGraph.sort(new Comparator<Node>(){
        //     @Override
        //     public int compare(Node x, Node y){
        //         return x.indegree - y.indegree;
        //     }
        // });
        if(sortedGraph.size() == 0) return new ArrayList<>();
        return sortedGraph;
    }

    // u -> v
    void insert(int u, int v){
        Node uNode = Graph.getOrDefault(u, new Node(u));
        Node vNode = Graph.getOrDefault(v, new Node(v));
        uNode.outNodes.add(v);
        vNode.indegree++;
        Graph.put(u, uNode);
        Graph.put(v, vNode);
        dependSet.add(u);
        dependSet.add(v);
    }

    public static void main(String[] Args){
        Solution2 s = new Solution2();
        int[][] prerequisites = new int[][]{{1,0},{1,2},{0,1}};
        int[] res = s.findOrder(3, prerequisites);
        for(int r: res){
            System.out.println(r);
        }
    }
}