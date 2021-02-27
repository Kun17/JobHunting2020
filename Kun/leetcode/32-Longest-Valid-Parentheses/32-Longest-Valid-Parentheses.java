import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        int preCount = 0;
        int curCount = 0;
        Stack<Character> stack = new Stack<>();
        Stack<Integer> lenStack = new Stack<>();
        for(Character c: s.toCharArray()){
            if(c == '(') {
                stack.push(c);
                lenStack.push(curCount);
                preCount = Math.max(curCount, preCount);
                curCount = 0;
            }
            else {
                if(stack.isEmpty() || stack.pop() != '(') {
                    preCount = Math.max(curCount, preCount);
                    curCount = 0;
                } else {
                    curCount += 2+lenStack.pop();
                }
            }
        }
        return Math.max(curCount, preCount);
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        System.out.println(s.longestValidParentheses("()("));
    }
}