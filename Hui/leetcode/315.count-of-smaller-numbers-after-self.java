/*
 * @lc app=leetcode id=315 lang=java
 *
 * [315] Count of Smaller Numbers After Self
 */

// @lc code=start
class Solution {
    /*
    Time O(nlogn)
    Space O(n)
    */
    class Num {
        int index;
        int val;
        public Num(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        Integer[] count = new Integer[nums.length];
        Arrays.fill(count, 0);
        Num[] temp = new Num[nums.length];
        Num[] numObj = new Num[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numObj[i] = new Num(i, nums[i]);
        }

        mergeSort(numObj, 0, nums.length - 1, count, temp);
        List<Integer> ret = new ArrayList<Integer>(Arrays.asList(count));

        return ret;
    }

    public void mergeSort(Num[] nums, int si, int ei, Integer[] count, Num[] temp) {
        if (si >= ei) {
            return;
        }

        int mid = si + (ei - si) / 2;
        mergeSort(nums, si, mid, count, temp);
        mergeSort(nums, mid + 1, ei, count, temp);

        merge(nums, si, ei, count, temp);
    }

    public void merge(Num[] nums, int si, int ei, Integer[] count, Num[] temp) {
        for (int i = si; i <= ei; i++) {
            temp[i] = new Num(nums[i].index, nums[i].val);
        }

        int mid = si + (ei - si) / 2;
        int i = si, j = mid + 1;
        for (int k = si; k <= ei; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j++];
            } else if (j == ei + 1) {
                nums[k] = temp[i];
                count[temp[i].index] += j - (mid + 1);
                i++;
            } else if (temp[i].val <= temp[j].val) {
                nums[k] = temp[i];
                count[temp[i].index] += j - (mid + 1);
                i++;
            } else {
                nums[k] = temp[j++];
            }
        }
    }
}
// @lc code=end

