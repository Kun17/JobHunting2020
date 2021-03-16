import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    static final int ALPHABETIC_SIZE = 26;

    static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;
        TrieNode(){
            this.children = new TrieNode[ALPHABETIC_SIZE];
            this.isEndOfWord = false;
            for(int i = 0; i < ALPHABETIC_SIZE; ++i){
                children[i] = null;
            }
        }
    }

    static TrieNode root = new TrieNode();

    static void insert(String key){
        key = key.toLowerCase();
        int len = key.length();
        TrieNode cur = root;
        for(int i = 0; i < len; ++i){
            int idx = key.charAt(i) - 'a';
            if(cur.children[idx] == null){
                cur.children[idx] = new TrieNode();
            }
            cur = cur.children[idx];
        }
        cur.isEndOfWord = true;
    }

    static boolean search(String key){
        key = key.toLowerCase();
        int len = key.length();
        TrieNode cur = root;
        for(int i = 0; i < len; ++i){
            int idx = key.charAt(i) - 'a';
            if(cur.children[idx] == null)
                return false;
            cur = cur.children[idx];
        }
        return cur != null && cur.isEndOfWord;
    }
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (x, y) -> (x.length() - y.length()));
        int len = words.length;
        List<String> res = new ArrayList<>();
        for(int i = 0; i < len; i++){
            if(findInTrie(words[i], 0)){
                res.add(words[i]);
            }
            insert(words[i]);
        }
        return res;
    }
    
    private boolean findInTrie(String word, int s){
        int len = word.length();
        if(s == len) return true;
        for(int i = s+1; i <= len; ++i){
            String pre = word.substring(s, i);
            if(search(pre) && findInTrie(word, i))
                return true;
        }
        return false;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        String[] words = new String[]{"cat", "dog", "catdog"};
        System.out.println(s.findAllConcatenatedWordsInADict(words));
    }
}