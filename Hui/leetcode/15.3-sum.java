/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
/*
    Duplicate check for every k, i, j
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i -1]) continue;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                } else if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                    k--;
                } else if (nums[j] + nums[k] + nums[i] > 0) {
                    k--;
                } else if (nums[j] + nums[k] + nums[i] < 0) {
                    j++;
                } else {
                    ret.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
            }
        }
        return ret;


        // List<List<Integer>> ret = new ArrayList<List<Integer>>();
        // Arrays.sort(nums);
        // for(int k = 0; k < nums.length - 2; k++) {
        //     if(k > 0 && nums[k] == nums[k - 1]) {
        //         continue;
        //     }
        //     int i = k + 1;
        //     int j = nums.length - 1;
        //     while(i < j) {
        //         if(i > k + 1 && nums[i] == nums[i - 1]) {
        //             i++;
        //             continue;
        //         }
        //         if(j < nums.length - 1 && nums[j] == nums[j+1]) {
        //             j--;
        //             continue;
        //         }
        //         if(nums[i] + nums[j] + nums[k] == 0) {
        //             ret.add(Arrays.asList(nums[k], nums[i], nums[j]));
        //             i++;
        //         } else if(nums[i] + nums[j] + nums[k] < 0) {
        //             i++;
        //         } else {
        //             j--;
        //         }
        //     }
        // }
        // return ret;
    }
}
// @lc code=end

