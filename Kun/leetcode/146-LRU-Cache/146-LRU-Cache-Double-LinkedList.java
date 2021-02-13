import java.util.Map;

import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

class LRUCache3 {

    class DLinkedNode{
        DLinkedNode prev;
        DLinkedNode next;
        int key;
        int value;
        DLinkedNode(){};
        DLinkedNode(int key,int val){this.key = key;this.value = val;}
    }

    int capacity;
    int size;
    DLinkedNode head, tail;
    Map<Integer, DLinkedNode> cache;

    private void initDLinkedList(){
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    private void addNode(DLinkedNode node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        this.size++;
    }

    private void remove(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        this.size--;
    }

    private void moveToHead(DLinkedNode node){
        remove(node);
        addNode(node);
    }

    public LRUCache3(int capacity) {
        this.cache = new HashMap<>();
        initDLinkedList();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        DLinkedNode curNode = cache.get(key);
        moveToHead(curNode);
        return curNode.value;
    }
    
    public void put(int key, int value) {
        DLinkedNode curNode = new DLinkedNode(key, value);
        if(cache.containsKey(key)){
            curNode = cache.get(key);
            curNode.value = value;
            cache.put(key, curNode);
            moveToHead(curNode);
        } else {
            if(size == capacity){
                cache.remove(tail.prev.key);
                remove(tail.prev);
            }
            addNode(curNode);
            cache.put(key, curNode);
        }
    }

    public static void main(String[] Args){
        // ["LRUCache","put","put","get","put","get","put","get","get","get"]
        // [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        LRUCache3 l = new LRUCache3(2);
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