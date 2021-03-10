import java.util.Set;
import java.util.HashSet;

class Solution {
    public String longestDupSubstring(String s) {
        int len = s.length();
        int l = 1, r = len;
        String res = "";
        while(l < r){
            int window = (l + r)/2;
            String temp = binarySearch2(s, window);
            if(temp.length() > res.length()) res = temp;
            if(temp == "") r = window;
            else l = window+1;
        }
        return res;
    }

    private String binarySearch(String s, int window){
        int len = s.length();
        long hash = 0;
        int base = (1 << 31) - 1;
        Set<Integer> seen = new HashSet<>();
        for(int i = 0; i <= len - window; i++){
            if(i == 0){
                for(int j = 0; j < window; j++){
                    hash *= 26;
                    hash += s.charAt(i+j) - 'a';
                    hash %= base;
                }
            } else {
                hash -= (Math.pow(26, window - 1) * (s.charAt(i-1) - 'a')) % base;
                hash *= 26;
                hash += s.charAt(i+window-1) - 'a';
                hash %= base;
            }
            if(seen.contains((int)hash)) return s.substring(i, i+window);
            else seen.add((int)hash);
        }
        return "";
    }

    private String binarySearch2(String s, int window){
        int len = s.length();
        Set<String> seen = new HashSet<>();
        for(int i = 0; i <= len - window; i++){
            String sub = s.substring(i, i+window);
            if(seen.contains(sub)) return sub;
            else seen.add(sub);
        }
        return "";
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        System.out.println(s.longestDupSubstring("zxcvdqkfawuytt"));
    }
}