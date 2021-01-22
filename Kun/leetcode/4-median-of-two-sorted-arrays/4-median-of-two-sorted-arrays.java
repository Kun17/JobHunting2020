class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArr =  new int[nums1.length + nums2.length];
        int i = 0, j = 0;
        while (i < nums1.length || j < nums2.length){
            if (i < nums1.length && (j >= nums2.length || nums1[i] < nums2[j])) {
                mergedArr[i+j] = nums1[i];
                i++;
            } 
            if (j < nums2.length && (i >= nums1.length || nums2[j] <= nums1[i])) {
                mergedArr[i+j] = nums2[j];
                j++;
            }
        }
        if ((mergedArr.length) % 2 == 0) {
            return (((double)mergedArr[(mergedArr.length)/2 -1] + (double)mergedArr[(mergedArr.length)/2])/2);
        }
        return (double)(mergedArr[(mergedArr.length)/2]);
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        System.out.println(s.findMedianSortedArrays(nums1, nums2));
    }
}