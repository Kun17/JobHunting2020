import java.util.Arrays;


class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        Arrays.sort(nums);
        int start = 2*nums[nums.length-1] - 1;
        int end = 1;
        while (start > end) {
            int mid  = (start + end) /2;
            if (calSum(nums, mid) <= threshold) {
                if (mid -1 > 0 && calSum(nums, mid - 1) > threshold) return mid;
                start = mid;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private int calSum (int[] nums, int divisor) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] % divisor == 0) {
                sum += nums[i]/divisor;
            } else {
                sum += nums[i]/divisor + 1;
            }
        }
        return sum;
    }

    public static void main(String[] Args) {
        Solution s  = new Solution();
        System.out.println(s.smallestDivisor(new int[]{21212,10101,12121}, 1000000));
    }
}
