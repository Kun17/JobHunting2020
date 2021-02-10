import java.util.List;
import java.util.ArrayList;

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        List<Integer> numsArray = new ArrayList<>();
        for(int num: nums){
            numsArray.add(num);
        }
        List<Integer> path = new ArrayList<>();
        dfs(numsArray, path);
        return res;
    }

    void dfs(List<Integer> numsArray, List<Integer> path){
        if(numsArray.isEmpty()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < numsArray.size(); i++){
            int next = numsArray.get(i);
            path.add(next);
            numsArray.remove(i);
            dfs(numsArray, path);
            numsArray.add(i, next);;
            path.remove(path.size() - 1);
        }
    }
}