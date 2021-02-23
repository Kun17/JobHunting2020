import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0;
        int count2 = 0;

        Integer candidate1 = null;
        Integer candidate2 = null;

        for(int num: nums){
            if(candidate1 != null && candidate1 == num){
                count1++;
            } else if(candidate2 != null && candidate2 == num){
                count2++;
            } else if(count1 == 0){
                candidate1 = num;
                count1++;
            } else if(count2 == 0){
                candidate2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        List<Integer> res = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for(int num: nums){
            if(candidate1 != null && num == candidate1) count1++;
            if(candidate2 != null && num == candidate2) count2++;
        }
        if(count1 > nums.length/3) res.add(candidate1);
        if(count2 > nums.length/3) res.add(candidate2);
        return res;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        int[] nums = new int[]{1,2};
        System.out.println(s.majorityElement(nums).toString());
    }
}