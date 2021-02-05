class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            if(!isSpecial(c)) {
                sb.append(c);
                continue;
            }
            if(isDigit(c)) {
                String num = constructNum(i, s);
                i += num.length();
                int endPos = findEndPos(i, s);
                int time = Integer.valueOf(num);
                for(int j = 0; j < time; j++){
                    String child = decodeString(s.substring(i+1, endPos));
                    sb.append(decodeString(child));
                }
                i = endPos;
            }
        }
        return sb.toString();
    }

    boolean isSpecial(char c){
        if(c >= '0' && c <= '9' || c == '[' || c == ']') return true;
        return false;
    }

    boolean isDigit(char c){
        if(c >= '0' && c <= '9') return true;
        return false;
    }

    String constructNum(int i, String s){
        StringBuilder sb = new StringBuilder();
        for(int j = i; j < s.length(); j++){
            char c = s.charAt(j);
            if(isDigit(c)) sb.append(c);
            else break;
        }
        return sb.toString();
    }

    int findEndPos(int i, String s){
        int pow = 0;
        int endLoc = i;
        for(int j = i; j < s.length(); j++){
            char c = s.charAt(j);
            if(c == '[') pow++;
            if(c == ']') pow--;
            if(pow == 0){
                endLoc = j;
                break;
            }
        }
        return endLoc;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        System.out.println(s.decodeString("3[a2[c]]"));
    }
}