/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> ret = new ArrayList<Interval>();
        if (schedule.size() == 0) return ret;
        
        PriorityQueue<Interval> heap = new PriorityQueue<Interval>((a, b) -> a.start - b.start);
        for (List<Interval> list: schedule) {
            for (Interval interval: list) {
                heap.add(interval);
            }
        }
        
        Interval cur = heap.poll();
        int end = cur.end;
        
        while (heap.size() > 0) {
            if (heap.peek().start > end) {
                ret.add(new Interval(end, heap.peek().start));
            }
            
            cur = heap.poll();
            end = Math.max(end, cur.end);
        }
        
        
        return ret;
    }
}
