import java.util.Arrays;

class Solution {
    int[] edges;
    int edgeLen;
    int[] packageNums;
    int len;
    public boolean makesquare(int[] nums) {
        len = nums.length;
        if(len < 4) return false;
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if(sum%4 != 0) return false;
        edgeLen = sum/4;
        Arrays.sort(nums);
        this.packageNums = new int[len];
        for(int i = 0; i < len; i++){
            this.packageNums[i] = nums[len-1-i];
        }
        this.edges = new int[4];
        return dfs(0);
    }

    private boolean dfs(int start){
        if(start == len && edges[0] == edges[1] && edges[1] == edges[2] && edges[2] == edges[3] && edges[3] == edgeLen) return true;
        for(int i = 0; i < 4; i++){
            if(edges[i] + packageNums[start] <= edgeLen){
                edges[i] += packageNums[start];
                if(dfs(start+1)) return true;
                edges[i] -= packageNums[start];
            }
        }
        return false;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        int[] nums = new int[]{1,1,2,2,2};
        System.out.println(s.makesquare(nums));
    }
}