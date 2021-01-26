class Solution {
    public double myPow(double x, int n) {
        // If using abs value of n, we would encounter max value problem, that minimum negative n's abs value cannot be achieved
        // So we use recursion!
        // Let's get started with basic recursion
        long N  = n;
        if (N < 0) {
            N = -N;
            x = 1/x;
        }
        if (N == 1) return x;
        double cur = x;
        double res = 1.0;
        for (long i = N; i > 0; i = i/2){
            if (i%2 == 1) {
                res = res * cur;
            } 
            cur *= cur;
        }   
        return res;
    }

    public static void main(String[] Args){
        Solution s =new Solution();
        System.out.println(s.myPow(8.84372, -5));
        //System.out.println(s.myPow(2.0000, -2147483648));
    }
}