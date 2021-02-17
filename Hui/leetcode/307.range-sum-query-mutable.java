/*
 * @lc app=leetcode id=307 lang=java
 *
 * [307] Range Sum Query - Mutable
 */

// @lc code=start
class NumArray {
    int[] tree;
    int n;
    int[] nums;
    public NumArray(int[] nums) {
        int x = (int) (Math.ceil(Math.log(nums.length) / Math.log(2)));
        int size = 2 * (int) Math.pow(2, x) - 1;
        this.tree = new int[size];
        this.n = nums.length;
        this.nums = nums;
        construct(0, nums.length - 1, 0);
    }

    public void construct(int s, int e, int idx) {
        // System.out.println(s + " " + e + " " + idx);
        if (s > e) return;
        if (s == e) {
            tree[idx] = nums[s];
        } else {
            int mid = s + (e - s) / 2;
            construct(s, mid, 2 * idx + 1);
            construct(mid + 1, e, 2 * idx + 2);
            tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2];
        }
    }
    
    public void update(int index, int val) {
        update(0, n - 1, 0, index, val - nums[index]);
        nums[index] = val;
    }
    
    public void update(int s, int e, int idx, int target, int val) {
        
        if (s == e) {
            tree[idx] += val;
        } else {
            int mid = s + (e - s) / 2;
            if (s <= target && target <= mid) {
                update(s, mid, 2 * idx + 1, target, val);
            } else {
                update(mid + 1, e, 2 * idx + 2, target, val);
            }
            tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2];
        }
    }
    
    public int sumRange(int left, int right) {
        return query(left, right, 0, n - 1, 0);
    }

    public int query(int l, int r, int s, int e, int idx) {
        if (r < s || e < l) {
            return 0;
        }

        if (l <= s && e <= r) {
            return tree[idx];
        }

        int mid = s + (e - s) / 2;
        return query(l, r, s, mid, 2 * idx + 1) + query(l, r, mid + 1, e, 2 * idx + 2);
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
// @lc code=end

