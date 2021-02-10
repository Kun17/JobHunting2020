import java.util.List;
import java.util.ArrayList;

class Solution {
    List<List<String>> combs;
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        combs = new ArrayList<>();
        List<String> single = new ArrayList<>();
        isPartition(s, 0, single, 4);
        for(List<String> nums: combs){
            StringBuilder sb = new StringBuilder();
            for(String num: nums){
                sb.append(num);
                sb.append(".");
            }
            if(sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
                res.add(sb.toString());
            }
        }
        return res;
    }

    void isPartition(String s, int start, List<String> path, int times){
        if(start == s.length() && times == 0){
            combs.add(new ArrayList<>(path));
            return;
        }
        if(times == 0) return;
        for(int i = start + 1; i <= 3 + start && i <= s.length(); i++){
            String num = s.substring(start, i);
            if(isValid(num)) {
                path.add(num);
                isPartition(s, i, path, times - 1);
                path.remove(path.size() - 1);
            }
        }
    }

    boolean isValid(String num){
        if(num.length() >= 2){
            if(num.charAt(0) == '0') return false;
        }
        return Integer.valueOf(num) <= 255 && Integer.valueOf(num) >= 0;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        System.out.println(s.restoreIpAddresses("25525511135").toString());
    }
}