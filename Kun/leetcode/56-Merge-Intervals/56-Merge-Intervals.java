import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        // If we can sort the intervals according to the x of the intervals
        // we only need to check if x(i+1) < y(i), because x(i+1) >= x(i)
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> resTemp = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++){
            if (resTemp.isEmpty() || resTemp.get(resTemp.size()-1)[1] < intervals[i][0]){
                resTemp.add(intervals[i]);
            } else {
                resTemp.get(resTemp.size()-1)[1] = Math.max(resTemp.get(resTemp.size()-1)[1], intervals[i][1]);
            }
        }
        return resTemp.toArray(new int[resTemp.size()][]);
    }

    public static void main(String[] Args){
        Solution s  = new Solution();
        System.out.println(s.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}}));
    }
}