import java.util.Map;

import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

class LRUCache {


    int capacity;
    Map<Integer, Integer> map;
    LinkedList<Integer> rank;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.rank = new LinkedList<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        rank.remove(Integer.valueOf(key));
        rank.add(0, key);
        return map.get(key);
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            rank.remove(Integer.valueOf(key));
        }
        if(rank.size() == capacity){
            int lastKey = rank.removeLast();
            map.remove(lastKey);
        }
        rank.add(0, key);
        map.put(key, value);
    }

    public static void main(String[] Args){
        // ["LRUCache","put","put","get","put","get","put","get","get","get"]
        // [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        LRUCache l = new LRUCache(2);
        l.put(1, 1);
        l.put(2, 2);
        System.out.println(l.get(1));
        l.put(3, 3);
        System.out.println(l.get(2));
        l.put(4, 4);
        System.out.println(l.get(1));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */