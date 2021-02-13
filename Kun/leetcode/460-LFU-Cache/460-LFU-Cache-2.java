import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ArrayList;

class LFUCache2 {
    int capacity;
    Map<Integer, Node> map;
    Map<Integer, Set<Integer>> countListMap;
    class Node {
        int count;
        int val;
        Node(int val){
            this.count = 1;
            this.val = val;
        }
    }

    // min is the min count;
    int min = 0;
    public LFUCache2(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.countListMap = new HashMap<>();
    }
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node curNode = map.get(key);
        Set<Integer> list = countListMap.get(curNode.count);
        list.remove(key);
        if(list.size() == 0 && curNode.count == min) min++;
        curNode.count++;
        Set<Integer> keyList = countListMap.getOrDefault(curNode.count, new LinkedHashSet<>());
        keyList.add(key);
        countListMap.put(curNode.count, keyList);
        return curNode.val;
    }
    
    public void put(int key, int value) {
        Node curNode = new Node(value);
        if(capacity <= 0) return;
        if(map.containsKey(key)){
            get(key);
            curNode = map.get(key);
            curNode.val = value;
            return;
        }
        if(map.size()== capacity){
            int evict = countListMap.get(min).iterator().next();
            countListMap.get(min).remove(evict);
            map.remove(evict);
        }
        map.put(key, curNode);
        Set<Integer> keyList = countListMap.getOrDefault(1, new LinkedHashSet<>());
        keyList.add(key);
        countListMap.put(1, keyList);
        min = 1;
    }

    public static void main(String[] Args){
        // ["LRUCache","put","put","get","put","get","put","get","get","get"]
        // [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        LFUCache2 l = new LFUCache2(3);
        l.put(1, 1);
        l.put(2, 2);
        l.put(3, 3);
        l.put(4, 4);
        System.out.println(l.get(4));
        System.out.println(l.get(3));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */