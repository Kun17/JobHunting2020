import java.util.ArrayList;
import java.util.List;

class Solution {
    public String largestNumber(int[] nums) {
        // We need to sort nums in a strange way, so this sorting method is the key to this problem
        // [9, 91, 2] should be [9, 2, 91]
        // This looks like a maxHeap
        // we extarct the largest key
        // [9, 2, 3, 900]
        // we can 1st sort the arr to its abs value
        // then try to assemble vals larger than the max value

        // the key part is we want to put the largest digit as forward as possible

        List<String> numsStrs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            numsStrs.add(String.valueOf(nums[i]));
        }
        numsStrs.sort((a,b)->(b+a).compareTo(a+b));

        String res = "";
        while(!numsStrs.isEmpty() && numsStrs.get(0).equals("0")) {
            numsStrs.remove(0);
        }
        for(String num: numsStrs){
            res += num;
        }
        return (res == "" ? "0":res);
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        System.out.println(s.largestNumber(new int[]{0,0}));
    }
}