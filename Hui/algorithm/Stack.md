# Stack

### Find Next Smaller/Greater Number

To find next smaller number in the array, push the element if greater than the top element in the stack. `while (meet a smaller element on the top)`, keep pop the stack and the current number is the first smaller element for each element pop out.

[Leetcode 84. Largestl Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/)

```java
class Solution {
    public int largestRectangleArea(int[] heights) {
        // from left to right to find the first smaller element
        Stack<Integer> stk = new Stack<Integer>();
        int[] rightSmaller = new int[heights.length];
        for(int i = 0; i < heights.length; i++) {
            while(stk.size() > 0 && heights[stk.peek()] > heights[i]) {
                rightSmaller[stk.pop()] = i;
            }

            stk.push(i);
        }

        while(stk.size() > 0) {
            rightSmaller[stk.pop()] = heights.length;
        }

        int[] leftSmaller = new int[heights.length];
        for(int i = heights.length - 1; i >= 0; i--) {
            while(stk.size() > 0 && heights[stk.peek()] > heights[i]) {
                leftSmaller[stk.pop()] = i;
            }
            
            stk.push(i);
        }

        while(stk.size() > 0) {
            leftSmaller[stk.pop()] = -1;
        }

        int maxArea = 0;
        for(int i = 0; i < heights.length; i++) {
            int len = rightSmaller[i] - leftSmaller[i] - 1;
            int area = len * heights[i];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
```



### Remove All Adjacent Duplicates in String

 消消乐

Use a stack to store the adjacent duplicate count while iterate the string. Whenever the top element reaches K duplicates, remove and go to next character in the string and pop the adjacent stack. Now the new top of the stack contains the previous character's count.

```java
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Integer> adjacent = new Stack<Integer>();
        StringBuilder sb = new StringBuilder(); 
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 || sb.length() == 0 || sb.charAt(sb.length() - 1) != s.charAt(i)) {
                sb.append(s.charAt(i));
                adjacent.push(1);
            } else {
                int count = adjacent.pop() + 1;
                if(count == k) {
                    sb.delete(sb.length() - k + 1, sb.length());
                } else {
                    adjacent.push(count);
                    sb.append(s.charAt(i));
                }
            }
        }

        return sb.toString();
    }
}
```

