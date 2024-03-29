class Solution {
    public int maxArea(int[] height) {
        if(height.length <= 1) return 0;
        int res = 0;
        int i = 0, j = height.length - 1;
        while(i < j){
            res = Math.max(res, (j - i) * Math.min(height[i], height[j]));
            if(height[i] < height[j]){
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}