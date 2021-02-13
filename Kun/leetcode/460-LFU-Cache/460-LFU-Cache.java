import java.util.Map;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class LFUCache {
    int capacity;
    class Node{
        int val;
        int count;
        int rankPos;
        Node(int val, int rankPos){
            this.count = 1;
            this.rankPos = rankPos;
            this.val = val;
        }
    }
    Map<Integer, Node> map;
    List<Integer> rank;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.rank = new ArrayList<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node curNode = map.get(key);
        curNode.count++;
        if(curNode.rankPos == 0) {
            map.put(key, curNode);
            return curNode.val;
        }
        moveToFront(key, curNode);
        return curNode.val;
    }

    private void moveToFront(int key, Node curNode){
        int curKey = key;
        int preKey = rank.get(curNode.rankPos - 1);
        Node preNode = map.get(preKey);
        if(curNode.rankPos != 0){
            while(curNode.rankPos > 0 && preNode.count <= curNode.count){
                preNode.rankPos++;
                curNode.rankPos--;
                rank.set(curNode.rankPos, curKey);
                rank.set(preNode.rankPos, preKey);
                map.put(preKey, preNode);
                map.put(curKey, curNode);
                if(curNode.rankPos == 0) break;
                preKey = rank.get(curNode.rankPos - 1);
                preNode = map.get(preKey);
            }
        }
    }
    
    public void put(int key, int value) {
        if(this.capacity == 0) return;
        if(map.containsKey(key)){
            Node curNode = map.get(key);
            curNode.count++;
            curNode.val = value;
            if(curNode.rankPos != 0) moveToFront(key, curNode);
        } else {
            if(rank.size() == capacity){
                int lastKey = rank.get(capacity - 1);
                rank.remove(capacity-1);
                map.remove(lastKey);
            }
            int rankPos = rank.size();
            rank.add(key);
            Node curNode = new Node(value, rankPos);
            map.put(key, curNode);
            if(curNode.rankPos != 0) moveToFront(key, curNode);
        }
    }

    public static void main(String[] Args){
        // ["LRUCache","put","put","get","put","get","put","get","get","get"]
        // [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        LFUCache l = new LFUCache(3);
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