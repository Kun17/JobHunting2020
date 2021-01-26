import java.util.Arrays;

class Solution {
    public int lengthOfLIS_DP(int[] nums) {
        // Looks like a DP problem, so I go with DP solution
        // f[i] stores the longest subsequence ends with nums[i]
        // for f[j], j needs to look back, find the max f[i], that nums[i] < nums[j]

        // Bottom up
        int[] f = new int[nums.length];
        int maxLen = 1;
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            maxLen = Math.max(f[i], maxLen);
        }
        return maxLen;
    }

    public int lengthOfLIS_DP_WithBinarySearch(int[] nums) {
        // Looks like a DP problem, so I go with DP solution
        // f[i] stores the longest subsequence ends with nums[i]
        // for f[j], j needs to look back, find the max f[i], that nums[i] < nums[j]

        // Bottom up
        int[] f = new int[nums.length];
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int insertP = Arrays.binarySearch(f,0,maxLen, nums[i]);
            if (insertP < 0) {
                insertP = -insertP -1;
            }
            if (insertP > maxLen - 1) maxLen++;
            f[insertP] = nums[i];
        }
        return maxLen;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        System.out.println(s.lengthOfLIS_DP_WithBinarySearch(new int[]{10,9,2,5,3,7,101,18}));
    }
}