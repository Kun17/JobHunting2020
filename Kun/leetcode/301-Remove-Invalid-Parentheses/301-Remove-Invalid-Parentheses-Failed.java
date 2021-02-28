import java.util.Stack;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

class Solution {
    Set<String> resSet;
    List<Integer> posList;
    Map<Integer, Character> posValMap;
    public List<String> removeInvalidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> posStack = new Stack<>();
        resSet = new HashSet<>();
        int len = s.length();
        posValMap = new HashMap<>();
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(c);
                posStack.push(i);
            } else if(c == ')'){
                if(stack.isEmpty()) {
                    posValMap.put(i, ')');
                } else {
                    posStack.pop();
                    stack.pop();
                }
            }
        }
        while(!posStack.isEmpty()){
            posValMap.put(posStack.pop(), '(');
        }
        posList = new LinkedList<>(posValMap.keySet());
        posList.sort((x,y) -> (x-y));

        StringBuilder sb = new StringBuilder();
        dfs(s,sb,0,0);
        return new LinkedList<String>(resSet);
    }

    private void dfs(String s, StringBuilder sb, int start, int layer){
        if(posList.isEmpty()){
            StringBuilder newSB = new StringBuilder(sb);
            if(start < s.length()) newSB.append(s.substring(start));
            resSet.add(newSB.toString());
            return;
        }
        int end = posList.remove(0);
        char toRemoveC = posValMap.get(end);
        List<Integer> posPos = new LinkedList<>();
        for(int i = start; i <= end; i++){
            char c = s.charAt(i);
            if(toRemoveC == ')' && c == toRemoveC){
                posPos.add(i);
            }
            sb.append(c);
        }
        if(toRemoveC == '('){
            posPos.clear();
            posPos.add(end);
        }
        for(int pos: posPos){
            sb.deleteCharAt(pos-layer);
            dfs(s, sb, end+1, layer+1);
            sb.insert(pos-layer, toRemoveC);
        }
        for(int i = start; i <= end; i++){
            sb.deleteCharAt(sb.length()-1);
        }
        posList.add(0, end);
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        System.out.println(s.removeInvalidParentheses("(((k()(("));
    }
}