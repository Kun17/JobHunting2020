class Solution {
    class Node {
        int val, EL = 1;
        Node left, right;
        Node(int val) {this.val = val;};
    }


    // Brutal force
    public int reversePairs_brutal_force(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                if (nums[i] > (long)2 * nums[j]) {
                    res++;
                }
            }
        }
        return res;
    }

    // Binary Search Tree
    public int reversePairs_binary_search_tree(int[] nums) {
        int n = nums.length;
        Node root = null;
        int res = 0;
        for (int i = 0; i < n ; i++){
            res += search(root, nums[i]*(long)2+1);
            root = insert(root, nums[i]);
        }
        return res;
    }

    private Node insert(Node curRoot, int val) {
        if (curRoot == null) return new Node(val);
        if (val < curRoot.val) {
            curRoot.left = insert(curRoot.left, val);
            return curRoot;
        } else {
            curRoot.right = insert(curRoot.right, val);
            curRoot.EL++;
            return curRoot;
        }
    }

    private int search(Node curRoot, long val){
        if(curRoot == null) return 0;
        if(curRoot.val == val) return curRoot.EL;
        if(curRoot.val < val) return search(curRoot.right, val);
        return curRoot.EL + search(curRoot.left, val);
    }

    // Merge sort
    int[] sh;

    public int reversePairs_merge_sort(int[] nums) {
        if (nums.length == 0) return 0;
        sh = new int[nums.length];
        return mergeSortNCount(nums, 0, nums.length-1);
    }

    private int mergeSortNCount(int[] nums, int s, int e) {
        if (s == e) return 0;
        int mid = s + (e-s)/2;
        int res = mergeSortNCount(nums, s, mid) + mergeSortNCount(nums, mid+1, e);
        for(int j = mid+1, i = s; j <= e; j++) {
            while(i <= mid && nums[i] <= nums[j]*2.0) {i++;}
            res += (mid - i + 1);
        }
        mergeSort(nums, s, mid, e);
        return res;
    }

    private void mergeSort(int[] nums, int s, int mid, int e){
        for(int i = s; i <= e;i++) sh[i] = nums[i];
        int i = s;
        int j = mid + 1;
        int p = s;
        while(p <= e) {
            if(j > e || sh[i] < sh[j] && i <= mid) {
                nums[p] = sh[i];
                i++;
                p++;
            } else {
                nums[p] = sh[j];
                j++;
                p++;
            }
        }
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        System.out.println(s.reversePairs_merge_sort(new int[]{1,3,2,3,1}));
    }
}