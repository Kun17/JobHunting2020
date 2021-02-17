/*
 * @lc app=leetcode id=406 lang=java
 *
 * [406] Queue Reconstruction by Height
 */

// @lc code=start
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Map<int[], Integer> map = new HashMap<int[], Integer>();
        // Arrays.sort(people, new Comparator<int[]>(){
        //     public int compare(int[] a, int[] b) {
        //         if (a[0] == b[0]) {
        //             return a[1] - b[1];
        //         }
        //         return a[0] - b[0];
        //     }
        // });

        PriorityQueue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                // if (a[0] == b[0]) {
                //     return a[1] - b[1];
                // }
                return a[0] - b[0];
            }
        });

        for (int[] p: people) {
            if (p[1] == 0) {
                q.add(p);
            }
            map.put(p, p[1]);
        }

        int[][] ret = new int[people.length][2];

        for (int i = 0; i < ret.length; i++) {
            ret[i] = q.poll();
            for (int[] p: people) {
                if (p[0] <= ret[i][0] && map.get(p) > 0) {
                    int count = map.get(p);
                    if (count == 1) {
                        q.add(p);
                    }
                    map.put(p, count - 1);
                }
            }
        }

        return ret;
    }
}
// @lc code=end

