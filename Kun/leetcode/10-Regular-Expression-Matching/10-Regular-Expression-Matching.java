class Solution {
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();

        // aab a*b -> ab a*b -> b a*b
        // aab .* -> ab .* -> b .*
        // ab .. -> a . -> 
        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if(p.length() > 1 && p.charAt(1) == '*'){
            return isMatch(s, p.substring(2)) || firstMatch && isMatch(s.substring(1), p);
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}