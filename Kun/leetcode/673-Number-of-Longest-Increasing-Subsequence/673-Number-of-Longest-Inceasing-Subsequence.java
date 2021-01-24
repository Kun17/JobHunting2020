import java.util.Map;
import java.util.HashMap;

class Solution {
    public int findNumberOfLIS(int[] nums) {
        // This is like a DP problem
        // Because to check if an arr [i,j] is keeping increasing
        // we only need to know [i,j-i] is increasing and a[j] is larger than a[j-1]
        // we can store all res in a map key: len of arr, val: nums of arr of such length
        // We can use the same trick again to avoid using two pointers i and j
        // f(i) returns the length of the longest array ends with a[i]
        // so for f[i+1], we only need to check a[i+1] is larger than a[i], which is default in this case
        // SO just need to find the max len a[0] - a[i] + 1
        // because we know the position i

        // We need a length num val of hashMap to store the result
        // To store the frequency of sequence[i] which ends with nums[i]
        
        Map<Integer, Integer> lenNumMap = new HashMap<>();

        // Using bottom up
        int maxLen = 0;
        // f[i] stores the length of sequence ended with nums[i]
        int[] l = new int[nums.length];
        int[] f = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            l[i] = 1;
            f[i] = 1;

            int subMaxLen = 0;
            for (int j = 0; j < i; j++){
                // a[i+1] > a[i]
                if (nums[i] > nums[j]) {
                    if (l[j] + 1 > subMaxLen) {
                        f[i] = f[j];
                        subMaxLen = l[j] + 1;
                        l[i] = subMaxLen;
                        // System.out.println("subMaxLen: " + subMaxLen + ", nums[i]:" +  nums[i]);
                        //lenNumMap.put(subMaxLen, lenNumMap.containsKey(subMaxLen)? lenNumMap.get(subMaxLen) +1: 1);
                    } else if (l[j] + 1 == subMaxLen) {
                        f[i] += f[j];
                    }
                }
                // System.out.println("f[]: " + Arrays.toString(f));
                // System.out.println("l[]: " + Arrays.toString(l));
                // System.out.println("lenNumMap: " + lenNumMap);
            }
            lenNumMap.put(l[i], lenNumMap.containsKey(l[i])? lenNumMap.get(l[i]) + f[i]: f[i]);
            maxLen = Math.max(subMaxLen, maxLen);
        }
        return lenNumMap.get(maxLen);
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        // 12457
        // 12357
        // 12347
        System.out.println(s.findNumberOfLIS(new int[]{1,2,4,3,5,4,7,2}));
    }
}
