import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // Using sliding window technique here
        // O(s)
        int len = s.length();
        char[] sb = new char[len];
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            sb[i] = s.charAt(i);
            if(i >= 9){
                String cur = new String(sb, i - 9, 10);
                if(map.containsKey(cur) && map.get(cur) == 0) {
                    res.add(cur);
                    map.put(cur, 1);
                } else if(!map.containsKey(cur)) map.put(cur, 0);
            }
        }
        return res;
    }

    public List<String> findRepeatedDnaSequences2(String s) {
        // Try Bitmask
        int len = s.length();
        Set<Integer> seen = new HashSet<>();
        Set<String> res = new HashSet<>();
        int bitmask = 0;
        int[] nums = new int[len];
        Map<Character, Integer> code = new HashMap(){{put('A',0); put('C',1); put('G',2); put('T',3);}};
        for(int i = 0; i < len; i++){
            nums[i] = code.get(s.charAt(i));
        }
        for(int i = 0; i < len - 9; i++){
            if(i == 0){
                for(int j = 0; j < 10; j++){
                    bitmask <<= 2;
                    bitmask |= nums[j];
                }
            } else {
                bitmask &= (~(3<<18));
                bitmask <<= 2;
                bitmask |= nums[i+9];
            }
            if(seen.contains(bitmask)) res.add(s.substring(i, i+10));
            else seen.add(bitmask);
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] Args){
        long q = (1 << 31) - 1;
        System.out.println(q);
        Solution s = new Solution();
        String str = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(s.findRepeatedDnaSequences2(str));
    }
}