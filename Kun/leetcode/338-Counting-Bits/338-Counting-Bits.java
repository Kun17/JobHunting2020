class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for(int i = 0; i <= num; i++){
            String s = Integer.toBinaryString(i);
            int len = s.length();
            int count = 0;
            for(int j = 0; j < len; j++){
                if(s.charAt(j) == '1') count++;
            }
            res[i] = count;
        }
        return res;
    }
}