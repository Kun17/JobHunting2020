import java.util.PriorityQueue;

class MedianFinder {

    /** initialize your data structure here. */
    // the larger half
    PriorityQueue<Integer> minHeap;
    // the smaller half
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(minHeap.size() > maxHeap.size()) maxHeap.offer(minHeap.poll());
    }
    
    public double findMedian() {
        if(maxHeap.size() > minHeap.size()) return maxHeap.peek();
        else return (maxHeap.peek() + minHeap.peek())/2.0;
    }

    public static void main(String[] Args){
        MedianFinder m = new MedianFinder();
        //[40],[],[12],[],[16],[],[14],[],[35],[],[19],[],[34],[],[35],[],[28],[],[35]
        int[] nums = new int[]{40,12,16,14,35,19,34,35,28};
        for(int num: nums){
            m.addNum(num);
        }
        System.out.println(m.findMedian());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */