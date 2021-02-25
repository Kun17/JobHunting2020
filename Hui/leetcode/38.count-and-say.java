class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        
        String s = countAndSay(n - 1);
        char c = s.charAt(0);
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                cnt++;
            } else {
                sb.append(cnt);
                sb.append(c);
                c = s.charAt(i);
                cnt = 1;
            }
        }
        
        sb.append(cnt);
        sb.append(c);
        
        return sb.toString();
    }
}
