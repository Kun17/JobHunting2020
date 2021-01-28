import java.util.Arrays;

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (a, b) -> Double.compare(Math.pow(a[0],2)+ Math.pow(a[1],2), (Math.pow(b[0],2)+ Math.pow(b[1],2))));
        int[][] res = new int[K][];
        for (int i = 0; i < K;i++){
            res[i] = points[i];
        }
        return res;
    }

    public int[][] kClosest_MyOwnSort(int[][] points, int K) {
        int N = points.length;
        int[] dists = new int[N];
        for (int i = 0; i < N; i++){
            dists[i] = dist(points[i]);
        }
        Arrays.sort(dists);
        int minKDist = dists[K-1];
        int[][] ans = new int[K][2];
        for (int i = 0, j =0; i < points.length;i ++){
            if (dist(points[i]) <= minKDist) {
                ans[j++] = points[i];
            }
        }
        return ans;
    }

    private int dist(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
}