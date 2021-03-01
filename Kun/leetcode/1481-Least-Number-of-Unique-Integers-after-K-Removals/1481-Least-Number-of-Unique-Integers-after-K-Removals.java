class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num: arr){
            countMap.put(num, countMap.getOrDefault(num, 0)+1);
        }
        int len = countMap.size();
        int[] countArr = new int[len];
        int i = 0;
        for(Map.Entry<Integer,Integer> entry: countMap.entrySet()){
            countArr[i++] = entry.getValue();
        }
        Arrays.sort(countArr);
        int sum = 0;
        for(int j = 0; j < len; j++){
            if(sum + countArr[j] > k){
                return len - j;
            }
            sum += countArr[j];
        }
        return 0;
    }
}