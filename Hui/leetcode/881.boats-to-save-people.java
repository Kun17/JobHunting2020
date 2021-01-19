/*
 * @lc app=leetcode id=881 lang=java
 *
 * [881] Boats to Save People
 */

// @lc code=start
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int s = 0, e = people.length - 1;
        int ret = 0;
        while(s <= e) {
            if(people[s] + people[e] <= limit) {
                s++;
            }
            e--;
            ret++;
        }

        return ret;
        
        /*
        O(N^2) Solution
        int[] count = new int[limit + 1];
        for(int i = 0; i < people.length; i++) {
            count[people[i]]++;
        }

        int ret = 0;
        int w = limit;
        while(w > 0) {
            while(count[w] > 0) {
                ret++;
                count[w]--;
                int target = limit - w;
                while(target > 0 && count[target] == 0) {
                    target--;
                }
                count[target]--;
            }
            w--;
        }

        return ret;
        */
    }
}
// @lc code=end

