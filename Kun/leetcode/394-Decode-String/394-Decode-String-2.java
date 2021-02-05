import java.util.Deque;
import java.util.ArrayDeque;

class Solution2 {
    public String decodeString(String s) {
        int len = s.length();
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            if(c != ']'){
                stack.push(c);
            } else {
                char start = stack.poll();
                StringBuilder wordSb = new StringBuilder();
                while(start != '['){
                    wordSb.append(start);
                    start = stack.poll();
                }
                StringBuilder numSb = new StringBuilder();

                while(!stack.isEmpty() && isDigit(stack.peek())){
                    numSb.append(stack.poll());
                }
                int num = Integer.valueOf(numSb.reverse().toString());
                for(int j = 0; j < num; j++){
                    for(int k = wordSb.length() - 1; k >= 0; k-- ){
                        stack.push(wordSb.charAt(k));
                    }
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pollLast());
        }
        return res.toString();
    }

    boolean isDigit(char c){
        if(c >= '0' && c <= '9') return true;
        return false;
    }

    public static void main(String[] Args){
        Solution2 s = new Solution2();
        System.out.println(s.decodeString("3[a2[c]]"));
    }
}