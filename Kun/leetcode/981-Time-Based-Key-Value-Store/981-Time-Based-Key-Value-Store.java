import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class TimeMap {
    Map<String, List<Data>> map;

    class Data {
        int timestamp;
        String value;
        Data(int timestamp, String value){this.timestamp = timestamp; this.value = value;}
    }

    /** Initialize your data structure here. */
    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!this.map.containsKey(key)) {
            List<Data> d = new ArrayList<>();
            d.add(new Data(timestamp, value));
            this.map.put(key, d);
        } else {
            List<Data> d = this.map.get(key);
            int index = binarySearch(d, timestamp);
            if (index < 0) {
                index = - index - 1;
                d.add(index, new Data(timestamp, value));
            } else {
                d.set(index, new Data(timestamp, value));
            }
        }
    }

    private int binarySearch(List<Data> d, int timestamp) {
        int start = 0;
        int end = d.size() - 1;
        if (timestamp > d.get(d.size() - 1).timestamp) return -d.size() -1;
        if (timestamp < d.get(0).timestamp) return -1;
        while(start < end) {
            int mid = (start + end) /2;
            if(d.get(mid).timestamp < timestamp) {
                if (d.get(mid+1).timestamp > timestamp) {
                    return - (mid+1) - 1;
                }
                start = mid + 1;
            } else if (d.get(mid).timestamp > timestamp) {
                end = mid;
            } else {
                return mid;
            }
        }
        return start;
    }
    
    public String get(String key, int timestamp) {
        if(this.map.containsKey(key)) {
            List<Data> d = this.map.get(key);
            int index = binarySearch(d, timestamp);
            if (index < -1) {
                index = - index - 1;
                return d.get(index-1).value;
            }
            if (index == -1) return "";
            if (index >= 0) {
                return d.get(index).value;
            }
        }
        return "";
    }

    public static void main(String[] Args) {
        TimeMap t = new TimeMap();
        t.set("love", "high", 10);
        t.set("love", "low", 20);
        System.out.println(t.get("love", 15));
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */