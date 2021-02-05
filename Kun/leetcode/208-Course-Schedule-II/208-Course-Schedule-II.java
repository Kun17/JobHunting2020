import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;

import java.util.List;

class Solution {
    class Node {
        int indgree;
        List<Integer> outNodes;
        Node(){this.indgree = 0; this.outNodes = new ArrayList<>();}
    }
    Map<Integer, Node> Graph;
    List<Integer> sortedGraph;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // BFS is impossible 
        // Let's try Kahn's algorithm to bring about topologically sorted graph
        this.Graph = new HashMap<>();
        sortedGraph = topologicalSort_Kahn(prerequisites);
        if(sortedGraph.isEmpty()) return new int[]{};
        return new int[]{1,2};
    }

    // Kahn's algorithm
    List<Integer> topologicalSort_Kahn(int[][] prerequisites){
        for(int[] relation: prerequisites){
            insert(relation[1], relation[0]);
        }
        List<Integer> L = new ArrayList<>();
        Set<Integer> S = new HashSet<>();
        for(Map.Entry<Integer, Node> entry: Graph.entrySet()){
            if(entry.getValue().indgree == 0){
                S.add(entry.getKey());
            }
        }
        if(S.isEmpty()) return L;
        for(Integer course: S){
            L.add(course);
            Node courseNode = Graph.get(course);
            while(!courseNode.outNodes.isEmpty()){
                Integer next = courseNode.outNodes.remove(0);
                Node nextNode =Graph.get(next);
                nextNode.indgree--;
                if(nextNode.indgree == 0) S.add(next);
            }
        }
        return L;
    }

    // u -> v
    void insert(int u, int v){
        Node uNode = Graph.getOrDefault(u, new Node());
        Node vNode = Graph.getOrDefault(v, new Node());
        uNode.outNodes.add(v);
        vNode.indgree++;
        Graph.put(u, uNode);
        Graph.put(v, vNode);
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        int[][] prerequisites = new int[][]{{1,0},{0,1}};
        int[] res = s.findOrder(2, prerequisites);
        for(int r: res){
            System.out.println(r);
        }
    }
}