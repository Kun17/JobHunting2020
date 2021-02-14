/*
 * @lc app=leetcode id=472 lang=java
 *
 * [472] Concatenated Words
 */

// @lc code=start
class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
            Arrays.sort(words, (a, b) -> a.length() - b.length());
            Trie trie = new Trie();

            List<String> ret = new ArrayList<String>();
            for(String w : words) {
                if(concatenated(w, 0, 0, trie)) {
                    ret.add(w);
                } else {
                    trie.insert(w);
                }
            }
            return ret;
    }

    public boolean concatenated(String s, int count, int pos, Trie trie) {
        Node cur = trie.root;
        for(int i = pos; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(cur.children[ch - 'a'] == null) {
                return false;
            }

            cur = cur.children[ch - 'a'];

            if(cur.isWord) {
                if(i == s.length() - 1) {
                    return count > 0;
                }
                if(concatenated(s, count + 1, i + 1, trie)) {
                    return true;
                }
            }
        }
        return false;
    }

    class Node {
        Node[] children;
        boolean isWord;

        public Node() {
            children = new Node[26];
            isWord = false;
        }
    }

    class Trie {
        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String s) {
            Node cur = root;
            for(int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if(cur.children[ch - 'a'] == null) {
                    cur.children[ch - 'a'] = new Node();
                }

                cur = cur.children[ch - 'a'];
            }

            cur.isWord = true;
        }
    }

    /* 
    Set<String> valid, invalid;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        valid = new HashSet<String>();
        for(String word : words) {
            valid.add(word);
        }
        invalid = new HashSet<String>();

        List<String> ret = new ArrayList<String>();
        for(String word : words) {
            for(int i = 0; i < word.length() - 1; i++) {
                if(valid(word.substring(0, i + 1)) && valid(word.substring(i + 1))) {
                    ret.add(word);
                    break;
                }
            }
        }

        return ret;
    }

    public boolean valid(String w) {
        if(valid.contains(w)) return true;
        if(invalid.contains(w)) return false;

        for(int i = 0; i < w.length() - 1; i++) {
            if(valid(w.substring(0, i + 1)) && valid(w.substring(i + 1))) {
                valid.add(w);
                return true;
            }
        }
        invalid.add(w);
        return false;
    }
    */
}
// @lc code=end

