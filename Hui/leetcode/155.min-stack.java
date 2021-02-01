/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stk, minStk;
    public MinStack() {
        stk = new Stack<Integer>();
        minStk = new Stack<Integer>();
    }
    
    public void push(int x) {
        stk.push(x);
        if(minStk.size() == 0 || minStk.peek() >= x) {
            minStk.push(x);
        }
    }
    
    public void pop() {
        // int cur = stk.pop();
        boolean b = (minStk.peek().equals(stk.pop()));
        if(b) {
            minStk.pop();
            // System.out.println(minStk.pop());
        }
        // StringBuilder astr = new StringBuilder("abc");
        // System.out.println(astr.toString() == astr.toString());
        // System.out.println(astr.equals(bstr));
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return minStk.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

