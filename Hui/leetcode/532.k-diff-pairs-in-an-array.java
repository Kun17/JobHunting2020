/*
 * @lc app=leetcode id=532 lang=java
 *
 * [532] K-diff Pairs in an Array
 */

// @lc code=start
class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ret = 0;
        for (int num: map.keySet()) {
            if (k == 0) {
                if (map.get(num) > 1) {
                    ret++;
                }
            } else {
                if (map.containsKey(num + k)) {
                    ret++;
                }
            }
        }
        return ret;
        // if (k == 0) {
        //     int ret = 0;
        //     Map<Integer, Integer> num = new HashMap<>();
        //     for (int n: nums) {
        //         if (num.containsKey(n) && num.get(n) == 1) {
        //             ret = ret + 1;
        //             num.put(n, 2);
        //         } else if (!num.containsKey(n)) {
        //             num.put(n, 1);
        //         }
        //     }
        //     return ret;
        // }
        // Map<Integer, int[]> map = new HashMap<>();
        // Set<Integer> visited = new HashSet<>();
        // for (int n: nums) {
        //     if (visited.contains(n)) continue;
        //     visited.add(n);
        //     int divide = n / k;
        //     int mod = n % k;
        //     if (n < 0) {
        //         divide = divide - 1;
        //         mod = mod + k;
        //     }
        //     int[] mods = map.getOrDefault(divide, new int[k + 1]);
        //     mods[mod]++;
        //     map.put(divide, mods);
        // }
        // // System.out.println(map);
        // int ret =  0;

        // int count0 = 0;
        // int countk = 0;
        // visited.clear();
        // for (int n: nums) {
        //     if (visited.contains(n)) continue;
        //     visited.add(n);
        //     if (n == 0) count0 = 1;
        //     if (n == -k) countk = 1;

        //     int divide = n / k;
        //     int mod = n % k;
        //     if (n < 0) {
        //         divide = divide - 1;
        //         mod = mod + k;
        //     }
        //     int[] mods = map.getOrDefault(divide + 1, new int[k + 1]);
        //     // System.out.println(n + " " + mods[mod]);
        //     ret += mods[mod];
        // }

        // return ret + count0 * countk;
    }
}
// @lc code=end

