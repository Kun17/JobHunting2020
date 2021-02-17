/*
 * @lc app=leetcode id=295 lang=java
 *
 * [295] Find Median from Data Stream
 */

// @lc code=start
class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
        minHeap = new PriorityQueue<Integer>((a, b) -> a - b);
    }
    
    public void addNum(int num) {
        minHeap.add(num);
        maxHeap.add(minHeap.poll());
        minHeap.add(maxHeap.poll());

        if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        int n = maxHeap.size() + minHeap.size();
        if (n % 2 == 0) {
            // System.out.println(maxHeap.peek() + " " + minHeap.peek());
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }

        return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

