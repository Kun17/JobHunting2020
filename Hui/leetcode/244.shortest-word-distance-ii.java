class WordDistance {
    
    Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            List<Integer> list = map.getOrDefault(words[i], new ArrayList<>());
            list.add(i);
            map.put(words[i], list);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> tree1 = map.get(word1);
        List<Integer> tree2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (i < tree1.size() && j < tree2.size()) {
            int index1 = tree1.get(i);
            int index2 = tree2.get(j);
            if (index1 < index2) {
                min = Math.min(min, index2 - index1);
                i++;
            } else {
                min = Math.min(min, index1 - index2);
                j++;
            }
        }
        
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
