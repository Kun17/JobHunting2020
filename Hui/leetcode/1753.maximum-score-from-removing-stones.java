class Solution {
    public int maximumScore(int a, int b, int c) {
        if (c < a) {
            int temp = a;
            a = c;
            c = temp;
        }
        
        if (c < b) {
            int temp = b;
            b = c;
            c = temp;
        }
        
        if (a + b <= c) {
            return a + b;
        }
        
        return (a + b - c) / 2 + c;
    }
    
//     int memo[][][];
//     public int maximumScore(int a, int b, int c) {
//         memo = new int[a + 1][b + 1][c + 1];
//         for (int i = 0; i <= a; i++) {
//             for (int j = 0; j <= b; j++) {
//                 for (int k = 0; k <= c; k++) {
//                     memo[i][j][k] = -1;
//                 }
//             }
//         }
        
//         return helper(a, b, c);
//     }
    
//     public int helper(int a, int b, int c) {
//         if (a == 0) {
//             return Math.min(b, c);
//         } else if (b == 0) {
//             return Math.min(a, c);
//         } else if (c == 0) {
//             return Math.min(a, b);
//         }
//         if (memo[a][b][c] != -1) {
//             return memo[a][b][c];
//         }
//         // remove a, b
//         int ab = helper(a - 1, b - 1, c);
//         // remove a, c
//         int ac = helper(a - 1, b, c - 1);
//         // remove b, c
//         int bc = helper(a, b - 1, c - 1);
//         // System.out.println(a + " " + b + " " + c + " " + memo.length + " " + memo[0].length + " " + memo[0][0].length);
//         memo[a][b][c] = Math.max(ab, Math.max(ac, bc)) + 1;
//         return memo[a][b][c];
//     }
}
