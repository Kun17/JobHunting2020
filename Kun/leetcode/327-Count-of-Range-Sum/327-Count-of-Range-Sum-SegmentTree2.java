class Solution {
    class segmentTree{
        int[] nums;
        long[] sTree;
        int[] sum;
        segmentTree(int[] input){
            this.nums = input;
            int len = input.length;
            int newLen = len;
            if((newLen&(-newLen)) != 0){
                newLen = ((newLen << 1) & (-newLen));
            }
            this.sTree = new long[2*newLen-1];
            build(0, len-1, 0);
        }

        public long query(int ql, int qh, int l, int h, int pos){
            if(ql <= l && qh >= h){
                return sTree[pos];
            }
            if(ql > h || qh < l){
                return 0;
            }
            int mid = (l+h)/2;
            return query(ql, qh, l, mid, 2*pos+1) + query(ql, qh, mid+1, h, 2*pos+2);
        }

        private void build(int l, int h, int pos){
            if(l == h){
                sTree[pos] = nums[l];
            } else {
                int mid = (l+h)/2;
                build(l, mid, 2*pos +1);
                build(mid+1, h, 2*pos+2);
                sTree[pos] = sTree[2*pos+1] + sTree[2*pos+2];
            }
        }
    }
    public int countRangeSum(int[] nums, int lower, int upper) {
        int len = nums.length;
        if(len == 0) return 0;
        segmentTree st = new segmentTree(nums);
        int count = 0;
        for(int i = 0; i < len; i++){
            for(int j = i; j < len; j++){
                long rangeSum = st.query(i, j, 0, len-1, 0);
                if(rangeSum >= lower && rangeSum <= upper) count++;
            }
        }
        return count;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        int[] nums = new int[]{-2147483647,0,-2147483647,2147483647};
        System.out.println(s.countRangeSum(nums, -564, 3864));
    }
}