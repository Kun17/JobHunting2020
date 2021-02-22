/*
 * @lc app=leetcode id=900 lang=java
 *
 * [900] RLE Iterator
 */

// @lc code=start
class RLEIterator {

    int index, count;
    int[] A;
    public RLEIterator(int[] A) {
        this.index = 0;
        this.count = 0;
        this.A = A;
    }
    
    public int next(int n) {
        if (index >= A.length) {
            return -1;
        }
        if (A[index] - count >= n) {
            count += n;
            return A[index + 1];
        }
        n -= A[index] - count;
        index += 2;
        while (index < A.length && A[index] < n) {
            n -= A[index];
            index += 2;
        }

        if (index >= A.length) {
            return -1;
        }

        count = n;
        return A[index + 1];
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */
// @lc code=end

