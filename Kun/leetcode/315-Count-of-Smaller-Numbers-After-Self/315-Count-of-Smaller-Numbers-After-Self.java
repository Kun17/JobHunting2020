import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        count = new int[len];
        int[] idx = new int[len];
        for(int i = 0; i < len; i++){
            idx[i] = i;
        }
        mergeSort(nums, idx, 0, len-1);
        List<Integer> res =new ArrayList<>();
        for(int i = 0; i < len;i++){
            res.add(count[i]);
        }
        return res;
    }

    private void mergeSort(int[] nums, int[] idx, int s, int e){
        if(s >= e) return;
        int mid = (s+e)/2;
        mergeSort(nums, idx, s, mid);
        mergeSort(nums, idx, mid+1, e);
        merge(nums, idx, s, mid, e);
    }

    private void merge(int[] nums, int[] idx, int s, int mid, int e){
        int l = s;
        int r = mid+1;
        int[] temp = new int[e-s+1];
        int i = 0;
        int rightCount = 0;
        while(i < e-s+1){
            if(r > e || l <= mid && nums[idx[l]] < nums[idx[r]]){
                temp[i] = idx[l];
                count[idx[l]] += rightCount;
                l++;
                i++;
            }
            if(i == e-s+1) break;
            if(l > mid || r <= e && nums[idx[r]] <= nums[idx[l]]){
                temp[i] = idx[r];
                r++;
                i++;
                rightCount++;
            }
        }
        for(int j = 0; j < e-s+1; j++){
            idx[s+j] = temp[j];
        }
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        int[] nums = new int[]{5,2,6,1};
        System.out.println(s.countSmaller(nums));
    }
}