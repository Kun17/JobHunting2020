/*
 * @lc app=leetcode id=1381 lang=java
 *
 * [1381] Design a Stack With Increment Operation
 */

// @lc code=start
class CustomStack {

    int[] stk;
    int top;
    public CustomStack(int maxSize) {
        this.stk = new int[maxSize];
        top = -1;
    }
    
    public void push(int x) {
        if(top + 1 < stk.length) {
            top++;
            stk[top] = x;
        }
    }
    
    public int pop() {
        if(top >= 0) {
            int ret = stk[top];
            top--;
            return ret;
        }

        return -1;
    }
    
    public void increment(int k, int val) {
        for(int i = 0; i < Math.min(top + 1, k); i++) {
            stk[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
// @lc code=end

