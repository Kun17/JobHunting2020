class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();

        
        dfs(nums, 0, 0, nums.length / 2, 0, list1);
        dfs(nums, nums.length / 2 + 1, nums.length / 2 + 1, nums.length - 1, 0, list2);
        
        Collections.sort(list1);
        Collections.sort(list2);
        
        // System.out.println(list1);
        // System.out.println(list2);
        int i = 0;
        int j = list2.size() - 1;
        
        int minDiff = Integer.MAX_VALUE;
        while (i < list1.size() && j >= 0) {
            int cur = list1.get(i) + list2.get(j);
            if (cur > goal) {
                minDiff = Math.min(minDiff, cur - goal);
                j--;
            } else if (cur < goal) {
                minDiff = Math.min(minDiff, goal - cur);
                i++;
            } else {
                return 0;
            }
        }
        
        return minDiff;
    }
    
    public void dfs(int[] nums, int pos, int si, int ei, int curSum, List<Integer> list) {
        // System.out.println(pos + " " + si + " " + ei);
        if (pos == ei + 1) {
            list.add(curSum);
            return;
        }
        
        dfs(nums, pos + 1, si, ei, curSum + nums[pos], list);
        dfs(nums, pos + 1, si, ei, curSum, list);
    }
}
