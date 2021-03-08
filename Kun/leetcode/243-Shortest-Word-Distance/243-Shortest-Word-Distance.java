class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int len = wordsDict.length;
        int i = -1, j = -1;
        int res = Integer.MAX_VALUE;
        for(int k = 0; k < len; ++k){
            if(wordsDict[k].equals(word1)) i = k;
            else if(wordsDict[k].equals(word2)) j = k;
            if(i >= 0 && j >= 0) res = Math.min(Math.abs(i-j), res);
        }
        return res;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        String[] wordsDict = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding", word2 = "practice";
        System.out.println(s.shortestDistance(wordsDict, word1, word2));
    }
}