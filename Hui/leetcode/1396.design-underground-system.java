/*
 * @lc app=leetcode id=1396 lang=java
 *
 * [1396] Design Underground System
 */

// @lc code=start
class UndergroundSystem {

    Map<Integer, Integer> timeMap;
    Map<Integer, String> startMap;
    Map<String, Long> sumMap;
    Map<String, Integer> countMap;
    public UndergroundSystem() {
        timeMap = new HashMap<>();
        startMap = new HashMap<>();
        sumMap = new HashMap<>();
        countMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        timeMap.put(id, t);
        startMap.put(id, stationName);
    }
    
    public void checkOut(int id, String stationName, int t) {
        int time = t - timeMap.get(id);
        String start = startMap.get(id);
        
        String key = start +"*" + stationName;
        int count = countMap.getOrDefault(key, 0);
        long sum = sumMap.getOrDefault(key, 0L);
        
        countMap.put(key, count + 1);
        sumMap.put(key, sum + time);
        
        timeMap.remove(id);
        startMap.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "*" + endStation;
        return (double) sumMap.get(key) / (double) countMap.get(key);
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
// @lc code=end

