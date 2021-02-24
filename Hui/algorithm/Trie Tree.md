# Trie Tree

```java
class Trie {

    Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.children[word.charAt(i) - 'a'] == null) {
                cur.children[word.charAt(i) - 'a'] = new Node();
            }
            cur = cur.children[word.charAt(i) - 'a'];
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node ret = find(word);
        return ret != null && ret.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node ret = find(prefix);
        return ret != null;
    }

    public Node find(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.children[word.charAt(i) - 'a'] == null) {
                return null;
            }
            cur = cur.children[word.charAt(i) - 'a'];
        }
        return cur;
    }

    class Node {
        Node[] children;
        boolean isWord;
        public Node() {
            children = new Node[26];
        }
    }
}
```

