/*
 * @lc app=leetcode id=731 lang=java
 *
 * [731] My Calendar II
 */

// @lc code=start
class MyCalendarTwo {
    class Meeting {
        int start, end;
        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    TreeSet<Meeting> meetings;
    TreeSet<Meeting> overlap;
    public MyCalendarTwo() {
        meetings = new TreeSet<Meeting>((a, b) -> a.start - b.start);
        overlap = new TreeSet<Meeting>((a, b) -> a.start - b.start);
    }
    
    public boolean book(int start, int end) {
        // System.out.println(start + " ----------  " + end);
        Meeting m = new Meeting(start, end);
        Meeting floor = overlap.floor(m);
        if (floor != null && floor.end > start) {
            // System.out.println(floor.start + " " + floor.end);
            return false;
        }
        Meeting ceiling = overlap.ceiling(m);
        if (ceiling != null && ceiling.start < end) {
            // System.out.println(ceiling.start + " " + ceiling.end);
            return false;
        }

        Meeting m2 = new Meeting(end, Integer.MAX_VALUE);
        Set<Meeting> possible = meetings.headSet(m2);
        for (Meeting prev: possible) {
            if (prev.end > start && prev.start < end) {
                overlap.add(new Meeting(Math.max(prev.start, start), Math.min(prev.end, end)));
                // System.out.println("add " + Math.max(prev.start, start) + " " + Math.min(prev.end, end));
            }
        }

        meetings.add(m);

        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
// @lc code=end

