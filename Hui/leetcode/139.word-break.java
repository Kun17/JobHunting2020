/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    // Time: O(n^3)
    // Space: O(n)
    // But using Tire Tree, takes less space to store wordDict
    public boolean wordBreak(String s, List<String> wordDict) {
        // build Trie tree
        Trie trie = new Trie();
        for(String word : wordDict) {
            trie.add(word);
        }

        // create a memory to remeber if s.subtring(i, end) is a valid word
        // m[i] = 0, have not seen yet
        // m[i] = 1, valid
        // m[i] = -1, invalid
        int[] m = new int[s.length()];
        
        return dfs(s, 0, m, trie);

    }

    public boolean dfs(String s, int start, int[] m, Trie trie) {
        if(start == s.length()) return true;
        if(m[start] != 0) return m[start] == 1;
        for(int i = start; i < s.length(); i++) {
            if(trie.search(s.substring(start, i + 1)) && dfs(s, i + 1, m, trie)) {
                m[start] = 1;
                return true;
            }
        }

        m[start] = -1;
        return false;
    }

    class Trie {
        class Node {
            boolean isWord;
            Node[] children;

            public Node() {
                isWord = false;
                children = new Node[256];
            }
        }

        Node root;
        public Trie() {
            root = new Node();
        }

        public void add(String word) {
            Node cur = root;
            for(int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if(cur.children[ch] == null) {
                    cur.children[ch] = new Node();
                }
                cur = cur.children[ch];
            }
            cur.isWord = true;
        }

        public boolean search(String word) {
            Node cur = root;
            for(int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if(cur.children[ch] == null) {
                    return false;
                }
                cur = cur.children[ch];
            }
            return cur.isWord;
        }
    }
}
// @lc code=end

