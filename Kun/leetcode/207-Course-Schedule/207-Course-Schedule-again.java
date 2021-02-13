import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

class Solution2 {
    class Node {
        int indgree;
        List<Integer> outNodes;
        Node(){
            this.indgree = 0;
            this.outNodes = new LinkedList<>();
        }
    }
    Map<Integer, Node> Graph;
    Set<Integer> dependentNodes;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Construct the graph
        constructGraph(prerequisites);

        // get all indegree 0 nodes into set
        LinkedList<Integer> leadNodes = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if(!dependentNodes.contains(i)){
                leadNodes.add(i);
                Graph.put(i, new Node());
            }
            else if(Graph.get(i).indgree == 0){
                leadNodes.add(i);
            }
        }

        // interate through set and update set with new nodes of zero indegrees
        int reducedEdge = 0;
        while(leadNodes.size()!= 0){
            int curNum = leadNodes.removeFirst();
            Node curNode = Graph.get(curNum);
            for(int next: curNode.outNodes){
                Node nextNode = Graph.get(next);
                nextNode.indgree--;
                if(nextNode.indgree == 0) {
                    leadNodes.add(next);
                }
                reducedEdge++;
            }
        }

        return reducedEdge == prerequisites.length;
    }

    private void constructGraph(int[][] prerequisites){
        this.Graph = new HashMap<>();
        this.dependentNodes = new HashSet<>();
        for(int i = 0; i < prerequisites.length; i++){
            dependentNodes.add(prerequisites[i][1]);
            dependentNodes.add(prerequisites[i][0]);
            insert(prerequisites[i][1], prerequisites[i][0]);
        }
    }

    private void insert(int src, int dst){
        Node srcNode = Graph.getOrDefault(src, new Node());
        srcNode.outNodes.add(dst);
        Node dstNode = Graph.getOrDefault(dst, new Node());
        dstNode.indgree++;
        Graph.put(src, srcNode);
        Graph.put(dst, dstNode);
    }

    public static void main(String[] Args){
        Solution2 s = new Solution2();
        int[][] prerequisites = new int[][]{{1,0}};
        System.out.println(s.canFinish(2, prerequisites));
    }
}