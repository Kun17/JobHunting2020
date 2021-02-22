class Solution {
    public int[] minOperations(String boxes) {
        int[] left = new int[boxes.length()];
        int balls = 0;
        for (int i = 0; i < boxes.length(); i++) {
            if (i == 0) {
                left[i] = 0;
            } else {
                left[i] = left[i - 1] + balls;
            }
            if (boxes.charAt(i) == '1') {
                balls++;
            }
        }
        
        int min = Integer.MAX_VALUE;
        int move = 0;
        balls = 0;
        for (int i = boxes.length() - 1; i >= 0; i--) {
            left[i] = left[i] + move;
            
            if (boxes.charAt(i) == '1') {
                balls++;
            }
            move += balls;
        }
        
        return left;
    }
}
