/*
 * @lc app=leetcode id=373 lang=java
 *
 * [373] Find K Pairs with Smallest Sums
 */

// @lc code=start
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (nums1.length == 0 || nums2.length == 0) return ret;
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        for (int i = 0; i < nums1.length; i++) heap.add(new int[]{nums1[i], nums2[0], 0});

        while (k-- > 0 && heap.size() > 0) {
            int[] cur = heap.poll();
            ret.add(Arrays.asList(cur[0], cur[1]));
            if (cur[2] == nums2.length - 1) continue;
            heap.add(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        return ret;
    }
}
// @lc code=end

