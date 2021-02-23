# Merge Two Digit Arrays to Get Max Number

`0 <= nums[i] <= 9`

merge two arrays to get the max number



for any given `i, j`

if `nums[i] > nums[j]` select `nums[i]`

if `nums[i] < nums[j]` select `nums[j]`

if `nums[i] == nums[j]` 

- compare first different number to the right, select the greater one to move `i` or `j`
- if `i` reaches the last first, then move `j` because we need to get closer to next `j` 
- if `j` reaches the last first, then move `i` because we need to get closer to next `i`



```java
						int i = 0, j = 0;
            int[] subret = new int[k];
            int m = 0;
            while (i < sub1.length && j < sub2.length) {
                if (sub1[i] == sub2[j]) {
                    int t = 0;
                    while (i + t < sub1.length && j + t < sub2.length && sub1[i + t] == sub2[j + t]) {
                        t++;
                    }
                    int nexti = i + t < sub1.length? sub1[i + t]: Integer.MIN_VALUE;
                    int nextj = j + t < sub2.length? sub2[j + t]: Integer.MIN_VALUE;

                    if (nexti > nextj) {
                        subret[m++] = sub1[i++];
                    } else {
                        subret[m++] = sub2[j++];                  
                    }
                } else if (sub1[i] < sub2[j]) {
                    subret[m++] = sub2[j++];
                } else {
                    subret[m++] = sub1[i++];
                }
            }

            while (i < sub1.length) {
                subret[m++] = sub1[i++];
            }

            while (j < sub2.length) {
                subret[m++] = sub2[j++];
            }

```

