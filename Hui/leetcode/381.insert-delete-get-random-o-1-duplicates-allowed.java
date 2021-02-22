/*
 * @lc app=leetcode id=381 lang=java
 *
 * [381] Insert Delete GetRandom O(1) - Duplicates allowed
 */

// @lc code=start
class RandomizedCollection {

    /** Initialize your data structure here. */
    Map<Integer, Integer> indexItem;
    Map<Integer, Set<Integer>> itemIndex;
    public RandomizedCollection() {
        indexItem = new HashMap<Integer, Integer>();
        itemIndex = new HashMap<Integer, Set<Integer>>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contained = itemIndex.containsKey(val);
        int index = indexItem.size();
        indexItem.put(index, val);
        Set<Integer> indexSet = itemIndex.getOrDefault(val, new HashSet<Integer>());
        indexSet.add(index);
        itemIndex.put(val, indexSet);
        
        return !contained;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!itemIndex.containsKey(val)) {
            return false;
        }
        if (indexItem.get(indexItem.size() - 1) == val) {
            indexItem.remove(indexItem.size() - 1);
            itemIndex.get(val).remove(indexItem.size());
            if (itemIndex.get(val).size() == 0) {
                itemIndex.remove(val);
            }
            // System.out.println(itemIndex);
            return true;
        }
        
        int removedIndex = -1;
        for (int i: itemIndex.get(val)) {
            removedIndex = i;
        }
        
        // replace ith item with the last one
        int lastItem = indexItem.get(indexItem.size() - 1);
        indexItem.put(removedIndex, lastItem);
        indexItem.remove(indexItem.size() - 1);
        
        // update itemIndex
        // remove idx from removed val
        itemIndex.get(val).remove(removedIndex);
        if (itemIndex.get(val).size() == 0) {
            itemIndex.remove(val);
        }
        
        // remove lastidx from last val
        itemIndex.get(lastItem).remove(indexItem.size());
        itemIndex.get(lastItem).add(removedIndex);
        
        // System.out.println(itemIndex);

        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        Random rand = new Random();
        int randIdx = rand.nextInt(indexItem.size());
        return indexItem.get(randIdx);
        
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// @lc code=end

