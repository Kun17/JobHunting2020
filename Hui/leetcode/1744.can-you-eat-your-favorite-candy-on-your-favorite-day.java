class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long[] count = new long[candiesCount.length];
        long sum = 0;
        for(int i = 0; i < candiesCount.length; i++) {
            sum += candiesCount[i];
            count[i] = sum;
        }
        
        boolean[] ret = new boolean[queries.length];
        for(int i = 0; i < queries.length; i++) {
            long min = queries[i][1];
            long max = (long) queries[i][1] * (long) queries[i][2];
            ret[i] = true;
            if(queries[i][0] > 0 && max + queries[i][2] <= count[queries[i][0] - 1]) {
                ret[i] = false;
            }
            if(min >= count[queries[i][0]]) {
                ret[i] = false;
            }
        }
        
        return ret;
    }
}
