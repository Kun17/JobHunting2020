import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

// Time complexity: O(n)
// Space complexity: O(n)
class Solution2 {
    public List<Integer> partitionLabels(String S) {
        int[] loc = new int[26];
        int len = S.length();
        for(int i = 0; i < len;i++){
            char c = S.charAt(i);
            if(loc[c-'a'] < i) loc[c-'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < len;i++){
            int start = i;
            char c = S.charAt(i);
            int curMax = loc[c-'a'];
            int j = i;
            while(j < curMax){
                c = S.charAt(j);
                int nextMax = loc[c-'a'];
                if(nextMax > curMax) curMax = nextMax;
                j++;
            }
            i = j;
            res.add(curMax - start + 1);
        }
        return res;
    }

    public List<Integer> partitionLabels_shortest(String S) {
        int[] loc = new int[26];
        int len = S.length();
        for(int i = 0; i < len;i++){
            char c = S.charAt(i);
            if(loc[c-'a'] < i) loc[c-'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int anchor = 0;
        int curMax = 0;
        for(int i = 0; i < len;i++){
            char c = S.charAt(i);
            curMax = Math.max(curMax, loc[c-'a']);
            if(i == curMax){
                res.add(i-anchor+1);
                anchor = i+1;
            }
        }
        return res;
    }

    public static void main(String[] Args){
        Solution2 s = new Solution2();
        System.out.println(s.partitionLabels("ababcbacadefegdehijhklij").toString());
    }
}