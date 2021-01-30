/*
 * @lc app=leetcode id=895 lang=java
 *
 * [895] Maximum Frequency Stack
 */

// @lc code=start
class FreqStack {

    Map<Integer, Integer> countMap;
    Map<Integer, Stack<Integer>> freqMap;
    int maxFreq = 0;
    public FreqStack() {
        countMap = new HashMap<Integer, Integer>();
        freqMap = new HashMap<Integer, Stack<Integer>>();
    }
    
    public void push(int x) {
        int count = 0;
        if(countMap.containsKey(x)) {
            count = countMap.get(x);
        }
        count++;
        countMap.put(x, count);

        if(freqMap.get(count) == null) {
            freqMap.put(count, new Stack<Integer>());
        }

        freqMap.get(count).push(x);
        maxFreq = Math.max(maxFreq, count);
    }
    
    public int pop() {
        int ret = freqMap.get(maxFreq).pop();

        // update countMap
        countMap.put(ret, countMap.get(ret) - 1);

        // update maxFreq by checking the stack size at this freq
        if(freqMap.get(maxFreq).size() == 0) {
            maxFreq--;
        }

        return ret;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
// @lc code=end

