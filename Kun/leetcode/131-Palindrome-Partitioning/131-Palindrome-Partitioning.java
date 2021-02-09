import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

class SolutionHaHa {
    public List<List<String>> partition(String s) {
        // we go through every possible substring that ends with pos i in s
        // assume set(i) contains all the res of string ends with s[i]
        // s(i, j) is the palindrome patitioning that starts with i and ends with j
        // s(i-1, j) is palindrome if s[i-1] == s[j] and s(i, j-1) is palindrome
        int len = s.length();
        boolean[][] DP = new boolean[len][len];
        Map<Integer, Set<String>> map = new HashMap<>();
        for(int gap = 0; gap < len; gap++){
            for (int i = 0; i < len; i++){
                int j = i - gap;
                if(j >= 0){
                    if(i == j) DP[j][i] = true;
                    else if (j == i - 1) DP[j][i] = (s.charAt(i) == s.charAt(j));
                    else {
                        DP[j][i] = DP[j+1][i-1] && (s.charAt(i) == s.charAt(j));
                    }
                    if(DP[j][i]) {
                        Set<String> oneLenAns = map.getOrDefault(i-j+1, new HashSet<>());
                        oneLenAns.add(s.substring(j, i+1));
                        map.put(i-j+1,oneLenAns);
                    }
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(Set<String> set: map.values()){
            List<String> resOfOneLen = new ArrayList<>(set);
            res.add(resOfOneLen);
        }
        return res;
    }

    public static void main(String[] Args){
        SolutionHaHa s = new SolutionHaHa();
        System.out.println(s.partition("aabaa"));
    }
}