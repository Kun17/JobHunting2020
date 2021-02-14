/*
 * @lc app=leetcode id=726 lang=java
 *
 * [726] Number of Atoms
 */

// @lc code=start
class Solution {
    int idx = 0;
    public String countOfAtoms(String formula) {
        Map<String, Integer> map = getMap(formula);
        List<String> list = new ArrayList<String>(map.keySet());
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(String element : list) {
            sb.append(element);
            int count = map.get(element);
            if(count != 1) {
                sb.append(count);
            }
        }
        return new String(sb);
    }

    public Map<String, Integer> getMap(String f) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        StringBuilder element = new StringBuilder();
        int count = 0;
        while(idx < f.length()) {
            char ch = f.charAt(idx);
            if(ch == '(') {
                updateMap(element, count, map);
                element = new StringBuilder();
                count = 0;
                idx++;
                Map<String, Integer> subMap = getMap(f);
                while(idx < f.length() && f.charAt(idx) >= '0' && f.charAt(idx) <= '9') {
                    count *= 10;
                    count += (int) (f.charAt(idx) - '0');
                    idx++;
                }
                if(count == 0) count = 1;
                for(String str : subMap.keySet()) {
                    if(!map.containsKey(str)) {
                        map.put(str, 0);
                    }
                    map.put(str, map.get(str) + subMap.get(str) * count);
                }
                count = 0;
            } else if(ch == ')') {
                updateMap(element, count, map);
                idx++;
                return map;
            } else {
                if(ch >= 'A' && ch <= 'Z') {
                    updateMap(element, count, map);
                    element = new StringBuilder();
                    element.append(ch);
                    count = 0;
                } else if(ch >= 'a' && ch <= 'z') {
                    element.append(ch);
                } else if(ch >= '0' && ch <= '9') {
                    count *= 10;
                    count += (int) (ch - '0');
                }

                if(idx == f.length() - 1) {
                    updateMap(element, count, map);
                    element = new StringBuilder();
                    count = 0;
                } 
                idx++;
            }

        }
        //""H11He49NO35B7N46Li20""
        //""K4(ON(SO3)2)2""
        //""(H)""

        return map;
    }

    public void updateMap(StringBuilder element, int count, Map<String, Integer> map) {
        if(element.length() > 0) {
            if(count == 0) count = 1;
            String elementStr = element.toString();
            if(map.containsKey(elementStr)) {
                map.put(elementStr, map.get(elementStr) + count);
            } else {
                map.put(elementStr, count);
            }
        }
    }
}
// @lc code=end

