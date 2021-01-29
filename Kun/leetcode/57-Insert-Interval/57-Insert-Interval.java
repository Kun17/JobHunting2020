import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 1. Evaluate the problem
        // to put into the new interval
        // We need to find the last end time that is bigger or just a little bit smaller than the start(newI)
        // Then the 1st start time that is less or slightly larger than the end(newI)
        // Sounds simple
        int start = newInterval[0], end = newInterval[1];
        int idx = 0, n = intervals.length;
        List<int[]> res = new ArrayList<>();

        while(idx < n && intervals[idx][0] < start) res.add(intervals[idx++]);

        // add newInterval
        int lastIdx = res.size()-1;
        if(res.isEmpty() || res.get(res.size()-1)[1] < start) {res.add(newInterval); lastIdx++;}
        else {
            if (res.get(res.size()-1)[1] < end) res.set(lastIdx, new int[]{res.get(res.size()-1)[0], end});
        }

        // add the rest
        while(idx < n){
            int[] last = res.get(lastIdx);
            if (intervals[idx][0] <= last[1] && intervals[idx][1] > last[1]) {
                res.set(lastIdx, new int[]{last[0], intervals[idx][1]});
            } else if (intervals[idx][0] > last[1]){
                res.add(intervals[idx]);
                lastIdx++;
            }
            idx++;
        }
        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        int[][] intervals1 = new int[][]{{1,3},{6,9}};
        int[] newInterval1 = new int[]{2,5};
        int[][] intervals2 = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval2 = new int[]{4,8};
        int[][] intervals3 = new int[][]{{1,5}};
        int[] newInterval3 = new int[]{5,7};
        int[][] res1 = s.insert(intervals2, newInterval2);
        for (int[] p: res1){
            System.out.println(p[0] + ", " + p[1]);
        }
    }
}