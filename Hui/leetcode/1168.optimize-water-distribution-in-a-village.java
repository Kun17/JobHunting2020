class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        PriorityQueue<Edge> heap = new PriorityQueue<>((a, b) -> a.c - b.c);
        
        for (int i = 1; i <= n; i++) {
            heap.add(new Edge(i, wells[i - 1]));
        }
        
        Map<Integer, List<Edge>> edges = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            edges.put(i, new ArrayList<>());
        }
        for (int[] p: pipes) {
            edges.get(p[0]).add(new Edge(p[1], p[2]));
            edges.get(p[1]).add(new Edge(p[0], p[2]));
        }
        
        int ret = 0;
        Set<Integer> visited = new HashSet<>();
        while (visited.size() < n) {
            Edge cur = heap.poll();
            if (visited.contains(cur.v)) continue;
            
            visited.add(cur.v);
            ret += cur.c;
            
            for (Edge next: edges.get(cur.v)) {
                if (!visited.contains(next.v)) {
                    heap.add(next);
                }
            }
        }
        
        return ret;
    }
    
    class Edge {
        int v;
        int c;
        
        public Edge(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }
}
