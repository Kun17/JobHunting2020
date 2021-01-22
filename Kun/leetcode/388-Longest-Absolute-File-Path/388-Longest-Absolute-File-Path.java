import java.util.Deque;
import java.util.ArrayDeque;



class Solution {
    public int lengthLongestPath(String input) {
        // Create a stack using deque
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        // Split the string by \n, substring without tab as prefix is in root level
        // with n tab, is in level n
        String[] sArr = input.split("\n");
        int maxLen = 0;
        for(String s : sArr){
            int level = s.lastIndexOf("\t") + 1;

            // preorder to the deepest node
            // curLen is the length of root to current node(included), 1 is the slash. - level is to deduct tabs

            // This pop is the key part of this algorithm, it pops the nodes equal or deeper than current node
            while(stack.size() > level + 1) stack.pop();

            int curLen = s.length() - level + 1 + stack.peek();
            stack.push(curLen);
            if (s.contains(".")) maxLen = Math.max(curLen, maxLen);
        }
        return maxLen;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        System.out.println(s.lengthLongestPath("a"));
    }
}