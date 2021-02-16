class Solution {
    public String largestMerge(String word1, String word2) {

        int i = 0;
        int j = 0;
        
        StringBuilder sb = new StringBuilder();
        while (i < word1.length() || j < word2.length()) {
            if (i == word1.length()) {
                sb.append(word2.charAt(j));
                j++;
            } else if (j == word2.length()) {
                sb.append(word1.charAt(i));
                i++;
            } else if (word1.charAt(i) < word2.charAt(j)) {
                sb.append(word2.charAt(j));
                j++;
            } else if (word1.charAt(i) > word2.charAt(j)) {
                sb.append(word1.charAt(i));
                i++;
            } else if (word1.substring(i).compareTo(word2.substring(j)) < 0) {
                sb.append(word2.charAt(j));
                j++;
            } else {
                sb.append(word1.charAt(i));
                i++;
            }
        }
        
        return sb.toString();
    }
}
