/*
 * @lc app=leetcode id=981 lang=java
 *
 * [981] Time Based Key-Value Store
 */

// @lc code=start
class TimeMap {
    Map<String, TreeSet<Value>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Value v = new Value(value, timestamp);
        if (map.containsKey(key)) {
            map.get(key).add(v);
        } else {
            TreeSet<Value> tree = new TreeSet<Value>((a, b) -> a.timestamp - b.timestamp);
            tree.add(v);
            map.put(key, tree);
        }
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        
        TreeSet<Value> tree = map.get(key);
        Value floor = tree.floor(new Value("", timestamp));
        if (floor == null) return "";
        return floor.value;
    }
    
    class Value {
        String value;
        int timestamp;
        public Value(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}


/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
// @lc code=end

