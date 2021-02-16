import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

class Solution2{
    class Node{
        int start;
        int end;
    }
    public int[] largestSumSubArrOfSubArr(int[] nums){
        int max = 0;
        int curMax = 0;
        int len = nums.length;
        boolean isEnd = false;
        Map<Integer, LinkedList<Node>> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            curMax += nums[i];
            if(curMax < 0) curMax = 0;
            else {
                if(!isEnd){
                    LinkedList<Node> posList = new LinkedList<>();
                    isEnd = true;
                }
            }
            if(curMax > max) {
                max = curMax;
            }
        }
        return max;
    }

    public static void main(String[] Args){
        Solution2 s = new Solution2();
        int[] nums = new int[]{-3, -4, 5, -1, -2, 3, 6};
        int[] nums2 = new int[]{-3, -4, -5, -1, -2, -3, -6};
        System.out.println(s.largestSumSubArrOfSubArr(nums));
        System.out.println(s.largestSumSubArrOfSubArr(nums2));
    }
}