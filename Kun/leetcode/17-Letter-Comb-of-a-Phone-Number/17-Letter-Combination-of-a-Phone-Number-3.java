import java.util.List;

import java.util.LinkedList;

class Solution3 {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
		if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i = 0; i < digits.length(); i++){
            int index = digits.charAt(i) - '0';
            while(ans.peek().length() == i) {
                String pre = ans.remove();
                for(char c: mapping[index].toCharArray()){
                    ans.add(pre + c);
                }
            }
        }
        return ans;
    }

    public static void main(String[] Args){
        Solution3 s = new Solution3();
        System.out.println(s.letterCombinations("9").toString());
    }
}