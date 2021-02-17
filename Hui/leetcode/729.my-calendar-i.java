/*
 * @lc app=leetcode id=729 lang=java
 *
 * [729] My Calendar I
 */

// @lc code=start
class MyCalendar {

    class Meeting {
        int start, end;
        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    TreeSet<Meeting> tree;
    public MyCalendar() {
        tree = new TreeSet<Meeting>((a, b) -> a.start - b.start);
    }
    
    public boolean book(int start, int end) {
        Meeting meeting = new Meeting(start, end);
        Meeting floor = tree.floor(meeting);
        if (floor != null && floor.end > start) {
            return false;
        }

        Meeting ceiling = tree.ceiling(meeting);
        if (ceiling != null && ceiling.start < end) {
            return false;
        }

        tree.add(meeting);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
// @lc code=end

