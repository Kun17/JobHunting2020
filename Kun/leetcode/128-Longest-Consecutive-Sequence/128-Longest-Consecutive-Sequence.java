import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length < 2) return nums.length;
        Arrays.sort(nums);
        int count = 1;
        int maxLen = 0;
        int prev = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == prev + 1) {
                count++;
                prev = nums[i];
            }
            else if (nums[i] == prev) continue;
            else {
                maxLen = Math.max(count, maxLen);
                count = 1;
                prev = nums[i];
            }
        }
        maxLen = Math.max(count, maxLen);
        return maxLen;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        int[] data = new int[]{
            9,1,4,7,3,-1,0,5,8,-1,6
        };
        System.out.println(s.longestConsecutive(data));
    }
}