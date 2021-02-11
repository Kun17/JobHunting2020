import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 4) return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(i != 0 && nums[i] == nums[i-1]) continue;
        	for(int j = i + 1; j < nums.length; j++){
                if(j != i+1 && nums[j] == nums[j-1]) continue;
        		long subtarget = target - (nums[i] + nums[j]);
        		int l = j + 1, r = nums.length - 1;
        		while(l < r){
        			long sum = nums[l] + nums[r];
        			if(sum < subtarget || (l  > j+ 1 && nums[l] == nums[l-1])){
        				l++;
        			} else if(sum > subtarget || (r < nums.length - 1 && nums[r] == nums[r+1])){
        				r--;
        			} else {
        				List<Integer> comb = new ArrayList<>();
                        comb.add(nums[i]);
                        comb.add(nums[j]);
                        comb.add(nums[l]);
                        comb.add(nums[r]); 
        				res.add(comb);
                        l++;
                        r--;
        			}
        		}
        	}
        }
        return res;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        int[] nums = new int[]{1,0,-1,0,-2,2};
        System.out.println(s.fourSum(nums, 0));
    }
}