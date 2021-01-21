# Binary Search

### Basic

Search for a target in a sorted array. If not found, return -1. Otherwise, return the index of the target. [Leetcode 704](https://leetcode.com/problems/binary-search/)

```java
    public int search(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        while(e - s > 1) {
            int mid = s + (e - s) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                s = mid;
            } else {
                e = mid;
            }
        }
        if(nums[s] == target) return s;
        if(nums[e] == target) return e;
        return -1;
    }
```



### First Position of an Element



