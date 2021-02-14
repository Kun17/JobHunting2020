class Solution {
    boolean invalidInput = false;
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> nextMap = new HashMap<Character, List<Character>>();
        Map<Character, Integer> degreeMap = new HashMap<Character, Integer>();
        Set<Character> set = new HashSet<Character>();
        
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words[i].length(); j++) {
                set.add(words[i].charAt(j));
            }
        }
        
        for(int i = 1; i < words.length; i++) {
            char[] edge = findEdge(words[i - 1], words[i]);
            if(edge == null) continue;
            
            char from = edge[0];
            char to = edge[1];
            
            List<Character> nextList = nextMap.getOrDefault(from, new ArrayList<Character>());
            nextList.add(to);
            nextMap.put(from, nextList);
            degreeMap.put(to, degreeMap.getOrDefault(to, 0) + 1);

        }
        
        if(invalidInput) return "";
        
        Queue<Character> queue = new LinkedList<Character>();
        for(Character ch: set) {
            // System.out.println(ch);
            if(degreeMap.getOrDefault(ch, 0) == 0) {
                // System.out.println("----" + ch);

                queue.add(ch);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(queue.size() > 0) {
            char cur = queue.poll();
            sb.append(cur);
            for(char next: nextMap.getOrDefault(cur, new ArrayList<Character>())) {
                int degree = degreeMap.get(next);
                if(degree == 1) {
                    degreeMap.remove(next);
                    queue.add(next);
                } else {
                    degreeMap.put(next, degree - 1);
                }
            }
        }
        // System.out.println(sb);
        if(degreeMap.size() != 0) {
            return "";
        }
        
        return sb.toString();
    }
    
    public char[] findEdge(String a, String b) {
        for(int i = 0; i < Math.min(a.length(), b.length()); i++) {
            if(a.charAt(i) != b.charAt(i)) {
                return new char[]{a.charAt(i), b.charAt(i)};
            }
        }
        
        if(a.length() > b.length()) {
            invalidInput = true;
        }
        
        return null;
    }
}
