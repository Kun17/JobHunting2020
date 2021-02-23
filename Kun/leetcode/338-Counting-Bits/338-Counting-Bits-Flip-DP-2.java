class Solution4 {
    public int[] countBits(int num) {
        int[] memo = new int[num+1];
        for(int i = 1; i <= num; i++){
            memo[i] = memo[i>>1] + i&1;
        }
        return memo;
    }

    public int[] countBits2(int num) {
        int[] memo = new int[num+1];
        for(int i = 1; i <= num; i++){
            memo[i] = memo[i&(i-1)] + 1;
        }
        return memo;
    }
}