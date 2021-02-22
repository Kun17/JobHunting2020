/*
 * @lc app=leetcode id=1424 lang=java
 *
 * [1424] Diagonal Traverse II
 */

// @lc code=start
class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int size = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                size++;
                int key = i + j;
                List<Integer> list = map.getOrDefault(i + j, new ArrayList<Integer>());
                list.add(nums.get(i).get(j));
                map.put(key, list);
            }
        }

        int[] ret = new int[size];
        int idx = 0;
        for (int key = 0; map.containsKey(key); key++) {
            for (int val: map.get(key)) {
                ret[idx++] = val;
            }            
        }

        return ret;
    }
}
// @lc code=end

