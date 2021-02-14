/*
 * @lc app=leetcode id=341 lang=java
 *
 * [341] Flatten Nested List Iterator
 */

// @lc code=start
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

public class NestedIterator implements Iterator<Integer> {
    /*
    Using stack to keep the top element to be a integer
    hasNext() makes the top of the stack must be an integer; if cannot find one, then retunr false;
    next() simply pops the stack top which has been processed by hasNext() previously to make sure the top must be an integer

    Time: 
    Construct: O(N + L)
    next(): O(1)
    hasNext(): O(N + L); average: O(N / N + L / N) = O(L / N)
    Space: O(N + L)
    */
    Stack<NestedInteger> stk;
    public NestedIterator(List<NestedInteger> nestedList) {
        stk = new Stack<NestedInteger>();
        for(int i = nestedList.size() - 1; i >= 0; i--) {
            stk.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stk.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        if(stk.size() == 0) return false;
        NestedInteger cur = stk.pop();
        while(!cur.isInteger()) {
            int len = cur.getList().size();
            for(int i = len - 1; i >= 0; i--) {
                stk.push(cur.getList().get(i));
            }
            if(stk.size() == 0) return false;
            cur = stk.pop();
        }

        stk.push(cur);
        return true;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
// @lc code=end

