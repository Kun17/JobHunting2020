/*
 * @lc app=leetcode id=1072 lang=java
 *
 * [1072] Flip Columns For Maximum Number of Equal Rows
 */

// @lc code=start
class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<String, Integer>();

        int ret = 0;
        for(int r = 0; r < matrix.length; r++) {
            StringBuilder row = new StringBuilder();
            StringBuilder flip = new StringBuilder();
            for(int c = 0; c < matrix[0].length; c++) {
                row.append(matrix[r][c]);
                flip.append(1 - matrix[r][c]);
            }
            String rowStr = row.toString();
            String flipStr = flip.toString();
            if(map.containsKey(rowStr)) {
                map.put(rowStr, map.get(rowStr) + 1);
                map.put(flipStr, map.get(flipStr) + 1);
            } else {
                map.put(rowStr, 1);
                map.put(flipStr, 1);
            }

            ret = Math.max(ret, map.get(rowStr));
        }

        // System.out.println(map);
        // int ret = 0;
        // for(int r = 0; r < matrix.length; r++) {
        //     StringBuilder flip = new StringBuilder();
        //     StringBuilder original = new StringBuilder();
        //     for(int c = 0; c < matrix[0].length; c++) {
        //         flip.append(1 - matrix[r][c]);
        //         original.append(matrix[r][c]);
        //     }
        //     System.out.println(original.toString());
        //     System.out.println(map.containsKey(flip));
        //     int count = map.get(original);
        //     if(map.containsKey(flip)) {
        //         count += map.get(flip);
        //     }

        //     ret = Math.max(ret, count);
        // }
        
        return ret;
    }



    /*
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int ret = 0;        
        for(int i = 0; i < matrix.length; i++) {
            int count = 0;
            for(int j = i; j < matrix.length; j++) {
                if(match(matrix[i], matrix[j])) {
                    count++;
                }
                ret = Math.max(ret, count);
            }
        }
        return ret;
    }

    public boolean match(int[] a, int[] b) {
        if(a[0] == b[0]) {
            return Arrays.equals(a, b);
        }

        for(int i = 0; i < a.length; i++) {
            if(a[i] == b[i]) {
                return false;
            }
        }

        return true;
    }
    */
}
// @lc code=end

