# Sort

### Buckets and The Pigeonhole Principle

[Leetcode 164. Maximum Gap](https://leetcode.com/problems/maximum-gap/)

Use bucket sort to avoid unecessary `diff` between adjacent elements. Partition the elements into `b`  buckets, which makes sure the `maxGap` in the range of on bucket must be smaller than the `maxGap(=prevMax - curMin)` where there is at least one empty bucket between current bucket and previous bucket.



Thus, the key point of this problem is to identify the following: exclude min and max, there is `n - 2` elements left; to keep at least one empty bucket, there should be `n - 1` buckets; then, the `interval = (max - min) / n - 1`. 



```java
class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length <= 1) return 0;
        // bucket sort
        // exclude min/max, should have n - 1 buckets to ensure at least 1 bucket is empty
        // where is also the max gap we are looking for
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num: nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        int n = nums.length;
        int interval = (int) Math.ceil((double) (max - min) / (n - 1));
        int[] bucketMin = new int[n - 1];
        int[] bucketMax = new int[n - 1];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, -1);

        for (int num: nums) {
            if (num == min || num == max) continue;
            int bucket = (num - min) / interval;
            bucketMin[bucket] = Math.min(bucketMin[bucket], num);
            bucketMax[bucket] = Math.max(bucketMax[bucket], num);
        }

        int prevMax = min;
        int maxGap = 0;
        for (int i = 0; i < n - 1; i++) {
            if (bucketMax[i] == -1) continue;
            maxGap = Math.max(maxGap, bucketMin[i] - prevMax);
            prevMax = bucketMax[i];
        }

        maxGap = Math.max(maxGap, max - prevMax);
        return maxGap;
    }
}
```

https://leetcode.wang/leetcode-164-Maximum-Gap.html

