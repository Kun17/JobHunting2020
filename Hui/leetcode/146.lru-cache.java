/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class LRUCache {

    Map<Integer, Node> map;
    int capacity;
    Node dummy;
    Node tail;
    public LRUCache(int capacity) {
        map = new HashMap<Integer, Node>();
        this.capacity = capacity;
        dummy = new Node(0, 0);
        tail = new Node(0, 0);
        dummy.next = tail;
        tail.prev = dummy;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;

        Node head = dummy.next;
        head.prev = node;
        dummy.next = node;
        node.prev = dummy;
        node.next = head;
        return node.val;
    }
    
    public void put(int key, int value) {
        if (!map.containsKey(key) && map.size() == capacity) {
            Node remove = tail.prev;
            tail.prev = remove.prev;
            remove.prev.next = tail;
            map.remove(remove.key);
        }
        
        Node node = null;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.val = value;
            node.prev.next = node.next;
            node.next.prev = node.prev;
        } else {
            node = new Node(key, value);
        }


        Node next = dummy.next;
        node.prev = dummy;
        node.next = next;
        dummy.next = node;
        next.prev = node;

        map.put(key, node);

    }

    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

