/*
 * @lc app=leetcode id=460 lang=java
 *
 * [460] LFU Cache
 */

// @lc code=start
class LFUCache {
    Map<Integer, Integer> kv;
    Map<Integer, Integer> kFreq;
    Map<Integer, LinkedHashSet<Integer>> lists;
    int c;
    int minFreq;
    public LFUCache(int capacity) {
        this.c = capacity;
        this.minFreq = 0;
        kv = new HashMap<Integer, Integer>();
        kFreq = new HashMap<Integer, Integer>();
        lists = new HashMap<Integer, LinkedHashSet<Integer>>();
    }
    
    public int get(int key) {
        if (!kv.containsKey(key)) return -1;
        // update freq

        int freq = kFreq.get(key);
        // update frequency
        kFreq.put(key, freq + 1);
        // update frequency list
        // remove from original list
        lists.get(freq).remove(key);
        if (lists.get(freq).size() == 0) {
            if (minFreq == freq) {
                minFreq++;
            }
            lists.remove(freq);
        }
        // add to the new list
        if (lists.containsKey(freq + 1)) {
            lists.get(freq + 1).add(key);
        } else {
            LinkedHashSet<Integer> list = new LinkedHashSet<Integer>();
            list.add(key);
            lists.put(freq + 1, list);
        }
        
        return kv.get(key);
    }
    
    public void put(int key, int value) {
        if (c <= 0) return;
        if (kv.containsKey(key)) {
            kv.put(key, value);
            get(key);
            return;
        }
        if (c == kv.size()) {
            int removed = lists.get(minFreq).iterator().next();
            lists.get(minFreq).remove(removed);
            if (lists.get(minFreq).size() == 0) {
                lists.remove(minFreq);
            }
            kFreq.remove(removed);
            kv.remove(removed);
        }

        minFreq = 1;
        kFreq.put(key, 1);
        kv.put(key, value);
        LinkedHashSet<Integer> list = lists.getOrDefault(1, new LinkedHashSet<Integer>());
        list.add(key);
        lists.put(1, list);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

