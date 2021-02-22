class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for(int i = 0; i <= num; i++){
            res[i] = hammingWeight(i);
        }
        return res;
    }
    private int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            n &= n-1;
            count++;
        }
        return count;
    }
}