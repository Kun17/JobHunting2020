public class Trie {
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

    public static void main(String[] Args){
        String[] keys = new String[]{"hello", "hew", "hell", "world"};
        for(int i = 0; i < keys.length; ++i){
            insert(keys[i]);  
        }
        System.out.println(search("haha"));
        System.out.println(search("hello"));
    }
}