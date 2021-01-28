import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // So 1st we sort the intervals according to its starting time
        // when we need to find a meeting room for the new meeting
        // we find the smallest end time in the past
        // if the start(i) >= end(min), we put this meeting the same meeting room of the smallest endtime one
        // if not, we need to ask for a new meeting room
        // This could easily be implemented via min heap or priority queue

        if(intervals.length == 0) return 0;

        // Sort the intervals
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Create a min heap
        PriorityQueue<Integer> PQ = new PriorityQueue<>(intervals.length, (a,b) -> Integer.compare(a, b));

        // add the 1st meeting
        PQ.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][0] >= PQ.peek()) {
                PQ.poll();
            }
            PQ.add(intervals[i][1]);
        }

        return PQ.size();
    }
}