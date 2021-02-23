class Solution3 {
    public int[] countBits(int num) {
        int[] memo = new int[num+1];
        int bound = 1;
        while(bound <= num){
            for(int i = bound; i <= 2* bound && i <= num; i++){
                memo[i] = memo[i-bound] + 1;
            }
            bound <<= 1;
        }
        return memo;
    }
}