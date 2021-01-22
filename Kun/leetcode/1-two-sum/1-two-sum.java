import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            numsMap.put(nums[i], i);
        }
        for (int i = 0 ; i < nums.length; i++) {
            int complement = target - nums[i];
            if(numsMap.containsKey(complement) && numsMap.get(complement) != i) {
                return new int[] {i, numsMap.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int n = keyboard.nextInt();
        int[] nums = new int[n];

        for(int i = 0; i < n; i++) {
            nums[i] = keyboard.nextInt();
        }
        int target = keyboard.nextInt();

        keyboard.close();

        Solution s = new Solution();

        int[] indices = s.twoSum(nums, target);

        if (indices.length == 2) {
            System.out.println(indices[0] + " " + indices[1]);
        } else {
            System.out.println("No solution found!");
        }
    }
}