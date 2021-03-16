class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        bktk(candidates, res, path, target, 0);
        return res;
    }
    
    void bktk(int[] candidates, List<List<Integer>> res, LinkedList<Integer> path, int target, int s){
        if(target == 0) {res.add(new ArrayList(path));return;}
        int len = candidates.length;
        for(int i = s; i < len; i++){
            if(target < candidates[i]) break;
            path.add(candidates[i]);
            bktk(candidates, res, path, target - candidates[i], i);
            path.removeLast();
        }
    }
}