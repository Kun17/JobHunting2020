/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Word> heap = new PriorityQueue<Word>(new WordComparator());
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num: map.keySet()) {
            heap.add(new Word(num, map.get(num)));
        }

        int[] ret = new int[k];
        while(k > 0) {
            k--;
            ret[k] = heap.poll().element;
        }
        return ret;
    }

    class Word {
        int freq;
        int element;

        public Word(int element, int freq) {
            this.element = element;
            this.freq = freq;
        }
    }

    class WordComparator implements Comparator<Word> {
        // @Override
        public int compare(Word a, Word b) {
            return b.freq - a.freq;
        }
    }
}
// @lc code=end

