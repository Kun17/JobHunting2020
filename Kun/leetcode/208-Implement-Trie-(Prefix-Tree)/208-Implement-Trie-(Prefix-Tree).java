class Trie {

    static final int ALPHABETICAL_SIZE = 26;
    static Trie root = new Trie();
    Trie[] children;
    boolean isEndOfWord;
    /** Initialize your data structure here. */
    public Trie() {
        this.children = new Trie[ALPHABETICAL_SIZE];
        this.isEndOfWord = false;
        for(int i = 0; i < ALPHABETICAL_SIZE; ++i){
            this.children[i] = null;
        }
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        int len = word.length();
        Trie cur = root;
        for(int i = 0; i < len; ++i){
            int idx = word.charAt(i) - 'a';
            if(cur.children[idx] == null){
                cur.children[idx] = new Trie();
            }
            cur = cur.children[idx];
        }
        cur.isEndOfWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int len = word.length();
        Trie cur = root;
        for(int i = 0; i < len; ++i){
            int idx = word.charAt(i) - 'a';
            if(cur.children[idx] == null)
                return false;
            cur = cur.children[idx];
        }
        return cur != null && cur.isEndOfWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int len = prefix.length();
        if(len == 0) return true;
        Trie cur = root;
        for(int i = 0; i < len; ++i){
            int idx = prefix.charAt(i) - 'a';
            if(cur.children[idx] == null)
                return false;
            cur = cur.children[idx];
        }
        return cur != null;
    }

    public static void main(String[] Args){
        Trie t = new Trie();
        System.out.println(t.startsWith("a"));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */