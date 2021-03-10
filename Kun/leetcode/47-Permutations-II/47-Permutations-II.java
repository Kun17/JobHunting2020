class Solution {
    int n;
    public List<List<Integer>> permuteUnique(int[] nums) {
        n = nums.length;
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num: nums) countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        bktk(countMap, res, path);
        return res;
    }
    
    void bktk(Map<Integer, Integer> countMap, List<List<Integer>> res, LinkedList<Integer> path){
        if(path.size() == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        Set<Integer> keySet = new HashSet<>(countMap.keySet());
        for(Integer key: keySet){
            int count = countMap.get(key);
            count--;
            if(count == 0) countMap.remove(key);
            else countMap.put(key, count);
            path.add(key);
            bktk(countMap, res, path);
            count++;
            countMap.put(key, count);
            path.removeLast();
        }
    }
}