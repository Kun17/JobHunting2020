/*
 * @lc app=leetcode id=1209 lang=java
 *
 * [1209] Remove All Adjacent Duplicates in String II
 */

// @lc code=start
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

    /*
    public String removeDuplicates(String s, int k) {
        Stack<Character> stk1 = new Stack<Character>();
        Stack<Character> stk2 = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            stk1.push(s.charAt(i));
        }

        int prevLen = -1;
        while(Math.max(stk1.size(), stk2.size()) != prevLen) {
            prevLen = Math.max(stk1.size(), stk2.size());
            if(stk1.size() > stk2.size()) {
                operate(stk1, stk2, k);
            } else {
                operate(stk2, stk1, k);
            }
        }

        StringBuilder sb = new StringBuilder();
        if(stk1.size() > 0) {
            while(stk1.size() > 0) {
                char ch = stk1.pop();
                sb.append(ch);
            }
            return sb.reverse().toString();
        }

        while(stk2.size() > 0) {
            char ch = stk2.pop();
            sb.append(ch);
        }
        return sb.toString();
    }

    public void operate(Stack<Character> from, Stack<Character> to, int k) {
        char ch = '#';
        int count = 0;
        while(from.size() > 0) {
            char cur = from.pop();
            to.push(cur);
            if(ch == cur) {
                count++;
            } else {
                ch = cur;
                count = 1;
            }

            if(count == k) {
                while(count > 0) {
                    count--;
                    to.pop();
                }
            }
        }
    }
    */
}
// @lc code=end

