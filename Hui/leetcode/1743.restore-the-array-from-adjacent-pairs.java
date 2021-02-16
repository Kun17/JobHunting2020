class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> edge = new HashMap<Integer, List<Integer>>();
        for(int[] p : adjacentPairs) {
            if(!edge.containsKey(p[0])) {
                edge.put(p[0], new ArrayList<Integer>());
            }
            edge.get(p[0]).add(p[1]);
            if(!edge.containsKey(p[1])) {
                edge.put(p[1], new ArrayList<Integer>());
            }
            edge.get(p[1]).add(p[0]);
        }
        
        int start = 0;
        for(int k : edge.keySet()) {
            if(edge.get(k).size() == 1) {
                start = k;
                break;
            }
        }
        // System.out.println(edge.size());
        int[] ret = new int[edge.size()];
        ret[0] = start;
        for(int i = 1; i < ret.length; i++) {
            // System.out.println(ret[i - 1]);
            for(int candidate : edge.get(ret[i - 1])) {
                if(i == 1 || candidate != ret[i - 2]) {
                    ret[i] = candidate;
                    break;
                }
            }
        }
        
        return ret;
    }
}
