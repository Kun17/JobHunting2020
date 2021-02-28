import java.util.Stack;

class Solution2 {
    public int longestValidParentheses(String s) {
        int res = 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            } else {
                stack.pop();
                if(!stack.isEmpty()){
                    res = Math.max(i - stack.peek(), res);
                } else {
                    stack.push(i);
                }
            }
        }
        return res;
    }

    public static void main(String[] Args){
        Solution2 s = new Solution2();
        System.out.println(s.longestValidParentheses("()(())"));
    }
}