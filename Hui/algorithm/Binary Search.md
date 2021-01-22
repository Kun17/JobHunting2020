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

`while` loop 循环条件 `while(e > s)`

infinite loop 通常出现在 `s = e - 1` , `mid = s` 并且恰好 `s = mid`. 

然而找target第一次出现的位置时，判断条件应设定为

```java
if(num[mid] < target) {
		s = mid + 1;
} else {
  	e = mid;
}
```

当`s = mid`时，`s = mid + 1`或者 `e = mid`，使得最终`s == e` 终止循环

[Leetcode 278 First Bad Version](https://leetcode.com/problems/first-bad-version/)

```java
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int s = 1, e = n;
        while(e > s) {
            int mid = s + (e - s) / 2;
            if(isBadVersion(mid)) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }

        return s;
    }
}
```



### Last Position of an Element

如果按照first position写，除condition要变成`nums[mid] <= target` 以外，最终结果为`s-1` 或者`s` (当target为num array最后一个元素时)

```java
    public int lastPosition(int[] nums, int target) {
        // write your code here
        if(nums.length == 0) return -1;
        int s = 0, e = nums.length - 1;
        while(e - s > 1) {
            int mid = s + (e - s) / 2;
            if(nums[mid] <= target) {
                s = mid;
            } else {
                e = mid;
            }
        }
        
        if(nums[e] == target) {
            return e;
        }
        if(nums[s] == target) {
            return s;
        }
        
        return -1;
    }
```



### Find Peak Element

```java
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        int s = 0, e = nums.length - 1;
        while(e - s > 1) {
            int mid = s + (e - s) / 2;
            if(nums[mid - 1] < nums[mid]) {
                s = mid;
            } else {
                e = mid;
            }
        }

        if(nums[s] > nums[e]) {
            return s;
        }

        return e;
    }
```



### Special Use

Use **First Position of an Element** to binary search all the possible answers to find the first one, the final answer.

Here are some examples

Split Array Largest Sum

```java
    public int splitArray(int[] nums, int m) {
        long s = 0L, e = 0L;
        for(int num : nums) {
            e += num;
            s = Math.max(s, num);
        }
        
        while(s < e) {
            long mid = s + (e - s) / 2;
            long sum = 0;
            int cnt = 1;
            for(int num : nums) {
                if(sum + num > mid) {
                    sum = num;
                    cnt++;
                } else {
                    sum += num;
                }
            }
            
            if(cnt <= m) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }

        return (int) s;

        // int[][] dp = new int[nums.length + 1][m + 1];
        // int[] sum = new int[nums.length + 1];
        // for(int i = 1; i <= nums.length; i++) {
        //     sum[i] = sum[i - 1] + nums[i - 1];
        //     dp[i][0] = Integer.MAX_VALUE;
        // }
        // for(int j = 1; j <= m; j++) {
        //     for(int i = 1; i <= nums.length; i++) {
        //         if(i < j) {
        //             continue;
        //         }
        //         dp[i][j] = Integer.MAX_VALUE;
        //         for(int k = 0; k < i; k++) {
        //             if(k + 1 < j) continue;
        //             dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sum[i] - sum[k]));
        //         }
        //     }
        // }
        // return dp[nums.length][m];
    }
```

Or Koko Eating Bananas

```java
		public int minEatingSpeed(int[] piles, int H) {
        long sum = 0;
        int e = 0; 
        for(int p: piles) {
            sum += p;
            e = Math.max(e, p);
        }

        int s = Math.max((int) (sum / H), 1);
        while(e > s) {
            int cur = s + (e - s) / 2;
            if(canEatAll(cur, piles, H)) {
                e = cur;
            } else {
                s = cur + 1;
            }
        }

        return (int) s;
    }

    public boolean canEatAll(int K, int[] ps, int H) {
        int count = 0;
        for(int p : ps) {
            count += p / K;
            if(p % K != 0) {
                count++;
            }
        }

        return count <= H;
    }
```

