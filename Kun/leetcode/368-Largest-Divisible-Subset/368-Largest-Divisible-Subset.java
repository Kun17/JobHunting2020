import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Lets try with DP 1st
        // if we sort nums to be in ascending order
        // like nums{a1,a2,a3,a4,a5...}
        // if f(i) return the largest subset that has a(i) as the last ele
        // {....ai}
        // if we want to add a(i+1), we only need to check if a(i+1)%a(i)==0
        // However, to get f(i+1)
        // for 1-j {}
        // f(i+1) = Math.max((a(i+1)%a(j)==0)? 1:0 + f(j))

        // Let's try with bottom up, because supposedly it's faster

        int[] f = new int[nums.length];
        // posValMap should store the last pos and its value
        Map<Integer, List<Integer>> posValMap = new HashMap<>();
        int maxLenPos = 0;
        int maxLen = 0;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            f[i] = 1;
            List<Integer> l = new ArrayList<>();
            l.add(nums[i]);
            posValMap.put(i, l);
            int subMaxLen = 1;

            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (f[j]+1 > subMaxLen) {
                        subMaxLen = f[j] + 1;
                        List<Integer> l2 = new ArrayList<Integer>(posValMap.get(j));
                        l2.add(nums[i]);
                        posValMap.put(i, l2);
                        f[i] = subMaxLen;
                    }
                }
            }
            if (subMaxLen > maxLen) {
                maxLen = subMaxLen;
                maxLenPos = i;
            }
        }
        return posValMap.get(maxLenPos);
    }

    public static void main(String[] Args) {
        Solution s  = new Solution();
        int[]  nums = new int[]{1,2,4,8};
        List<Integer> res = s.largestDivisibleSubset(nums);
        for(Iterator<Integer> it = res.iterator(); it.hasNext();){
            System.out.println(it.next());
        }
    }
}