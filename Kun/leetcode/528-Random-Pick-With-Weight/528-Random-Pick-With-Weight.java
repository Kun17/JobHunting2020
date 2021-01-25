import java.util.Random;
import java.util.Arrays;
import java.util.Comparator;

class Solution {

    // We transform w into arr of its percentage of total weight, which is the upper limit
    // a random double falls into p[i-1], p[i], return w[i]
    // Using binary search we can find the i, and return w[i]
    class m {
        int val;
        double p;
        int oriIdx;
        m(int val, int oI) {this.val = val; this.oriIdx = oI;}
    }
    m[] mw;
    public Solution(int[] w) {
        this.mw = new m[w.length + 1];
        this.mw[0] = new m(0,-1);
        this.mw[0].p = 0;
        for(int i = 1; i < mw.length; i++){
            this.mw[i] = new m(w[i-1], i-1);
        }
        Arrays.sort(this.mw, Comparator.comparingInt(a->a.val));
        int sum = 0;
        for (int i = 0; i < w.length; i++){
            sum += w[i];
        }
        for (int i = 1; i < mw.length; i++){
            mw[i].p = (double)mw[i].val/sum + mw[i-1].p;
        }
    }
    
    public int pickIndex() {
        Random rand = new Random();
        double rd = rand.nextDouble();
        return mw[binarySearch(rd)].oriIdx;
    }

    private int binarySearch(double rd){
        int start = 0;
        int end = mw.length - 1;
        while(start < end){
            int mid = (start + end)/2;
            if(mw[mid].p < rd) {
                if (mw[mid+1].p >= rd) {
                    return mid + 1;
                }
                start = mid;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] Args){
        Solution s = new Solution(new int[]{3,2,1});
        for (int i = 0; i < 10; i++){
            System.out.println(s.pickIndex());
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */