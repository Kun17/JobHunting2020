import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution2 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    private List<List<Integer>> kSum(int[] nums, int target, int start, int times){
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < times || start >= nums.length || start < 0 || target > nums[nums.length - 1] * times) return res;
        if(times == 2) return twoSum_HashSet(nums, target, start);

        for(int i = start; i < nums.length; i++){
            // skip the same number
            if (i != start && nums[i] == nums[i-1]) continue;
            for(List<Integer> next: kSum(nums, target - nums[i], i + 1, times - 1)){
                //next.add(nums[i]);
                //res.add(next);
                res.add(new ArrayList<>(Arrays.asList(nums[i])));
                res.get(res.size() - 1).addAll(next);
            }
        }
        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, int target, int start){
        List<List<Integer>> res = new ArrayList<>();
        int l = start, r = nums.length - 1;
        int sum;
        while(l < r){
            sum = nums[l] + nums[r];
            if(sum < target || (l > start && nums[l] == nums[l-1])) l++;
            else if(sum > target || (r < nums.length - 1) && nums[r] == nums[r + 1]) r--;
            else {
                List<Integer> ans = new ArrayList<>();
                ans.add(nums[l]);
                ans.add(nums[r]);
                res.add(ans);
                l++;
                r--;
            }
        }
        return res;
    }

    private List<List<Integer>> twoSum_HashSet(int[] nums, int target, int start){
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> s = new HashSet<>();
        for(int i = start; i < nums.length; i++){
            if(s.contains(target - nums[i]) && (res.isEmpty() || res.get(res.size() - 1).get(1) != nums[i])){
                res.add(Arrays.asList(target - nums[i], nums[i]));
            }
            s.add(nums[i]);
        }
        return res;
    }

    public static void main(String[] Args){
        Solution2 s = new Solution2();
        int[] nums = new int[]{1,0,-1,0,-2,2};
        System.out.println(s.fourSum(nums, 0));
    }
}