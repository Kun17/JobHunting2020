import java.util.List;
import java.util.ArrayList;

class Solution3 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        int len = nums.length;
        int bitInt = 1 << len;
        for(int i = 0; i < (int)Math.pow(2, len); i++){
            String bitmask = Integer.toBinaryString(bitInt | i).substring(1);
            List<Integer> oneRes = new ArrayList<>();
            for(int j = 0; j < len; j++){
                if(bitmask.charAt(j) == '1') {
                    oneRes.add(nums[j]);
                }
            }
            output.add(oneRes);
        }
        return output;
    }

    public static void main(String[] Args){
        Solution3 s = new Solution3();
        int[] nums = new int[]{1,2,3};
        System.out.println(s.subsets(nums).toString());
    }
}