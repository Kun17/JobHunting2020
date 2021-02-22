/*
 * @lc app=leetcode id=1286 lang=java
 *
 * [1286] Iterator for Combination
 */

// @lc code=start
class CombinationIterator {

    int[] index;
    boolean hasNext;
    String characters;
    public CombinationIterator(String characters, int combinationLength) {
        this.index = new int[combinationLength];
        for (int i = 0; i < combinationLength; i++) {
            this.index[i] = i;
        }
        this.hasNext = true;
        this.characters = characters;
    }
    
    public String next() {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < index.length; i++) {
            ret.append(characters.charAt(index[i]));
        }

        int mi = index.length - 1;
        while (mi >= 0 && index[mi] == characters.length() - 1 - (index.length - 1 - mi)) {
            mi--;
        }

        if (mi == -1) {
            hasNext = false;
        } else {
            index[mi]++;
            for (int i = mi + 1; i < index.length; i++) {
                index[i] = index[i - 1] + 1;
            }
        }
        return ret.toString();
    }
    
    public boolean hasNext() {
        return this.hasNext;
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end

