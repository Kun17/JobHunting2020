/*
 * @lc app=leetcode id=284 lang=java
 *
 * [284] Peeking Iterator
 */

// @lc code=start
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
	Queue<Integer> queue;
	Iterator<Integer> iterator;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
		this.queue = new LinkedList<Integer>();
		this.iterator = iterator; 
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if (queue.size() > 0) {
			return queue.peek();
		}
		int next = iterator.next();
		queue.add(next);
		return next;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if (queue.size() > 0) {
			return queue.poll();
		}
		return iterator.next();
	}
	
	@Override
	public boolean hasNext() {
	    return queue.size() > 0 || iterator.hasNext();
	}
}
// @lc code=end

