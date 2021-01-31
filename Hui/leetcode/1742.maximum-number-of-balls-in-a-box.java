class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int[] map = new int[46];
        int max = 0;
        for(int i = lowLimit; i <= highLimit; i++) {
            int sum = 0;
            int cur = i;
            while(cur > 0) {
                sum += cur % 10;
                cur /= 10;
            }
            map[sum]++;
            max = Math.max(max, map[sum]);
        }
    
        
        return max;
    }
}
