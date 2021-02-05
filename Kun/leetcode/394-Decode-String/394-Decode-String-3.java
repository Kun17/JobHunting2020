import java.util.Stack;

class Solution3 {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                k = ch - '0';
            } else if (ch == '['){
                countStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
            } else if(ch == ']'){
                StringBuilder decodedString = stringStack.pop();
                for (int currentK = countStack.pop(); currentK > 0; currentK--) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(ch);
            }
        }
        return currentString.toString();
    }

    public static void main(String[] Args){
        Solution3 s = new Solution3();
        System.out.println(s.decodeString("3[a2[c]]"));
    }
}