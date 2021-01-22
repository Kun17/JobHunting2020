class Solution {
    public int reverse(int x) {
        // When storing 32bit int in big endian
        // We have max int32 as 2^31-1, min int32 as -2^31
        // 2147483647 and -2147483648
        // Thus when reversing a number, we need to check when it reaches to 10 digit
        // The last digit is no big than 7 or less then -8
        // Well, or we could just check the absolute value
        // x/10 then x%10, we can get the last digit one by one

        int res = 0;
        while (x != 0) {
            int curDigit = x%10;
            res = res * 10 + curDigit;
            x = x/10;
            // if now x reaches to 0 digit, we need to check if 
            if ((res > Integer.MAX_VALUE/10 && x > 0) || (res == Integer.MAX_VALUE/10 && x > 7)){
                return 0;
            } else if (res < Integer.MIN_VALUE/10 && x < 0 || res == Integer.MIN_VALUE/10 && x < -8){
                return 0;
            }
        }
        return res;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        System.out.println(s.reverse(1147483649));
    }

}