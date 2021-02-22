import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Solution2 {
    List<List<Integer>> output;
    int setSize;
    int len;
    public List<List<Integer>> subsets(int[] nums) {
        output = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        len =  nums.length;
        for(setSize = 0; setSize <= len; setSize++){
            backtracking(nums, path, 0);
        }
        return output;
    }

    private void backtracking(int[] nums, List<Integer> path, int start){
        if(path.size() == setSize){
            output.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i < len; i++){
            path.add(nums[i]);
            backtracking(nums, path, i+1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] Args){
        Solution2 s = new Solution2();
        int[] nums = new int[]{1,2,3};
        System.out.println(s.subsets(nums).toString());
    }
}