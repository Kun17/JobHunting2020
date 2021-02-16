/*
 * @lc app=leetcode id=380 lang=java
 *
 * [380] Insert Delete GetRandom O(1)
 */

// @lc code=start
class RandomizedSet {

    /** Initialize your data structure here. */
    Map<Integer, Integer> valIdx;
    Map<Integer, Integer> idxVal;
    int size;
    public RandomizedSet() {
        valIdx = new HashMap<Integer, Integer>();
        idxVal = new HashMap<Integer, Integer>();
        size = 0;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(valIdx.containsKey(val)) {
            return false;
        }
        valIdx.put(val, size);
        idxVal.put(size, val);

        size++;
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!valIdx.containsKey(val)) {
            return false;
        }

        int idx = valIdx.get(val);
        int lastVal = idxVal.get(size - 1);
        // move last val to idx
        idxVal.put(idx, lastVal);
        valIdx.put(lastVal, idx);

        idxVal.remove(size - 1);
        valIdx.remove(val);

        size--;
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        int randIdx = rand.nextInt(size);

        return idxVal.get(randIdx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// @lc code=end

