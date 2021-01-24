/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Design Add and Search Words Data Structure
 */

// @lc code=start
class WordDictionary {

    Node root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new Node();
            }

            cur = cur.children[c - 'a'];
        }

        cur.isWord = true;
    }
    
    public boolean search(String word) {
        // System.out.println(word);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int len = q.size();
            while(len > 0) {
                len--;
                Node cur = q.poll();
                if(c == '.') {
                    for(Node next : cur.children) {
                        if(next != null) {
                            q.add(next);
                        }
                    }
                } else if(cur.children[c - 'a'] != null) {
                    q.add(cur.children[c - 'a']);
                }
            }
        }
        boolean found = false;
        int len = q.size();
        // System.out.println(len);
        while(len > 0) {
            len--;
            Node cur = q.poll();
            if(cur.isWord) {
                found = true;
                break;
            }
        }
        return found;
    }

    class Node {
        boolean isWord;
        Node[] children;

        public Node() {
            isWord = false;
            children = new Node[26];
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

