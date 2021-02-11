class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r){
            if(!isValid(s.charAt(l))){
                l++;
                continue;
            }
            if(!isValid(s.charAt(r))){
                r--;
                continue;
            }
            if(Character.toLowerCase(s.charAt(l))!= Character.toLowerCase(s.charAt(r))) return false;
            l++;
            r--;
        }
        return true;
    }

    private boolean isValid(char c){
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z');
    }
}