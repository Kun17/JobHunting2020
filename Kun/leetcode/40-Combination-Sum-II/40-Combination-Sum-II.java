class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        bktk(candidates, res, path, target, 0);
        return res;
    }
    
    void bktk(int[] candidates, List<List<Integer>> res, LinkedList<Integer> path, int target, int s){
        if(target == 0) {
            if(!res.contains(path)) res.add(new ArrayList<>(path));
            return;
        }
        int len = candidates.length;
        for(int i = s; i < len; i++){
            if(target < candidates[i]) break;
            if(i > s && candidates[i] == candidates[i-1]) continue;
            path.add(candidates[i]);
            bktk(candidates, res, path, target - candidates[i], i+1);
            path.removeLast();
        }
    }
}