import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());
        for(int num: nums){
            int size = output.size();
            for(int i =0; i < size; i++){
                List<Integer> subset = output.get(i);
                List<Integer> newSubset = new ArrayList<>(subset);
                newSubset.add(num);
                output.add(newSubset);
            }
        }
        return output;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        int[] nums = new int[]{1,2,3};
        System.out.println(s.subsets(nums).toString());
    }
}