/*
 * @lc app=leetcode id=225 lang=java
 *
 * [225] Implement Stack using Queues
 */

// @lc code=start
class MyStack {

    /** Initialize your data structure here. */
    Queue<Integer> q;
    public MyStack() {
        q = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q.add(x);
        while (q.peek() != x) {
            q.add(q.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return q.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

