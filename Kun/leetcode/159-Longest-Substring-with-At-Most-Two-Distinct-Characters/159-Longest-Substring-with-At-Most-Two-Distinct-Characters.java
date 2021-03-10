class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // 2 pointers
        int i = 0,j = 0;
        int len = s.length();
        Map<Character, Integer> countMap = new HashMap<>();
        int res = 0;
        while(j < len){
            char c = s.charAt(j);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            while(countMap.size() > 2){
                char ic = s.charAt(i++);
                int ict = countMap.get(ic);
                --ict;
                if(ict == 0) countMap.remove(ic);
                else countMap.put(ic, ict);
            }
            res = Math.max(res, j-i+1);
            ++j;
        }
        return res;
    }
}