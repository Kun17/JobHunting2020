import java.util.Comparator;
import java.util.TreeSet;
import java.lang.Runnable;
import java.util.function.Supplier;

class Solution2 {
    TreeSet<Integer> hi;
    TreeSet<Integer> lo;
    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comp = (a,b) -> nums[a] != nums[b]? nums[a] - nums[b]: a - b;
        hi = new TreeSet<>(comp);
        lo = new TreeSet<>(comp.reversed());

        Supplier<Double> median = (k % 2== 0)?
            () -> (nums[hi.first()]/2.0 + nums[lo.first()]/2.0):
            () -> ((double)nums[lo.first()]);

        Runnable balance = () -> {while(hi.size() > lo.size()) lo.add(hi.pollFirst());};

        double[] res = new double[nums.length - k + 1];
        for(int i = 0; i < k; i++) hi.add(i);
        balance.run();
        res[0] = median.get();

        for(int i = k; i < nums.length; i++){
            if(nums[i-k] <= res[i-k]) lo.remove(i-k);
            else hi.remove(i-k);
            lo.add(i);
            hi.add(lo.pollFirst());
            balance.run();
            res[i-k+1] = median.get();
        }

        return res;
    }   


    public static void main(String[] Args){
        Solution2 s = new Solution2();
        int[] nums = new int[]{1,2,3,4,2,3,1,4,2};
        double[] ress = s.medianSlidingWindow(nums, 3);
        for(double res: ress){
            System.out.println(res);
        }
    }
}