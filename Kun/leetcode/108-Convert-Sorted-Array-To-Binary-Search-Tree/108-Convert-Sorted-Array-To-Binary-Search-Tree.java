import apple.laf.JRSUIUtils.Tree;

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        // We can simply select the middle element as the root
        // Then use recursion
        return buildTree(nums, 0, nums.length - 1);
    }

    TreeNode buildTree(int[] nums, int s, int e){
        if (s > e) return null;
        int mid = (s + e)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, s, mid - 1);
        root.right = buildTree(nums, mid + 1, e);
        return root;
    }
}