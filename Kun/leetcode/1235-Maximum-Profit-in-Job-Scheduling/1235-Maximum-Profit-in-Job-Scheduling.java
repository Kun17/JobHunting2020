import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Comparator;


class Solution {

    class Job implements Comparable<Job> {
        int startTime;
        int endTime;
        int profit;
        Job(int startTime, int endTime, int profit){this.startTime = startTime; this.endTime =endTime; this.profit = profit;}

        @Override
        public int compareTo(Job otherJob){
            if ((startTime - otherJob.startTime) > 0) return 1;
            if ((startTime - otherJob.startTime) < 0) return -1;
            if((endTime - otherJob.endTime) > 0) return 1;
            if((endTime - otherJob.endTime) < 0) return -1;
            return 0;
        }
    }
    // This is my stack solution, it does not pass due to surpassing time limit, it is O(n^2)
    public int jobScheduling_stack(int[] startTime, int[] endTime, int[] profit) {
        // When you pick startTime[i], pick on startTime[j] should be larger than
        // endTime[i], startTime[k] should be larger than endTime[j]. So forth
        // Then find the largest profit possible out of them
        // But is there a clever way to find the solution
        // Lets's try with this straightdorward way 1st

        if (profit.length == 0) return 0;

        // We only need to find all startTime available for one endTime, then we go with each startTime respectively
        // Hence we can use stack to push all startTime
        // We store the index of every startTime to find the end time and profix
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> pStack = new ArrayDeque<>();
        int maxProfit = 0;

        int[][] sortInput = sort(startTime, endTime, profit);
        startTime = sortInput[0];
        endTime = sortInput[1];
        profit = sortInput[2];
        // Traverse through the startTime
        for(int i = 0; i < startTime.length; i++){
            stack.push(i);
            pStack.push(profit[i]);


            // We pop the head of the stack find every possible endTime and profit of it
            // push them to stack one by one
            // calculate all possible Profit of current i and get the max
            while(stack.peek() != null){
                int j = stack.poll();
                int curProfit = pStack.poll();
                int nextEndTime = endTime[j];
                int nextJ = Arrays.binarySearch(startTime, j, startTime.length, nextEndTime);
                if (nextJ < 0) nextJ = - nextJ - 1;
                // if nextJ is out of range, meaning next profit is not available, profit added before this should be settled
                if (nextJ >= startTime.length) {
                    maxProfit = Math.max(curProfit, maxProfit);
                    continue;
                }
                for (int k = nextJ; k < startTime.length; k++){
                    stack.push(k);
                    pStack.push(curProfit + profit[k]);
                }
            }
        }
        return maxProfit;
    }

    public int jobScheduling_DP(int[] startTime, int[] endTime, int[] profit) {
        // Using DP, subproblem of DP is that for job ends with time t, we find the max profit till time t
        // f[i] = f[i-1] + profit of job i
        // Notice we must make sure f[i] stores the max profit till job i(inclusive)
        // because finish time might be the same, so we don't use time but use job i as the boundry
        Job[] jobs = new Job[startTime.length];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, Comparator.comparingInt(a -> a.endTime));
        return scheduleJobs(jobs);
    }

    // Go with bottom up
    private int scheduleJobs(Job[] jobs) {
        int maxProfit = 0;
        int[] f = new int[jobs.length];
        f[0] = jobs[0].profit;
        for(int i = 1; i < jobs.length; i++) {
            // search for the job's index that has the finish time right before current job's start time
            // because f returns the max profit before i, so it's alway going up
            int lastJobIndex = binarySearch(jobs, jobs[i].startTime);
            if (lastJobIndex != -1) {
                f[i] = f[lastJobIndex] + jobs[i].profit;
            } else f[i] = Math.max(jobs[i].profit, f[i-1]);
            f[i] = Math.max(f[i], f[i-1]);
            maxProfit = Math.max(maxProfit, f[i]);
        }
        return maxProfit;
    }

    private int binarySearch(Job[] jobs, int startTime) {
        int start = 0;
        int end  = jobs.length - 1;
        while (start < end) {
            int mid = (start + end)/2;
            if (jobs[mid].endTime <= startTime) {
                if (jobs[mid + 1].endTime > startTime) {
                    return mid;
                }
                start = mid;
            } else {
                end = mid;
            }
        }
        return -1;
    }

    private int[][] sort (int[] startTime, int[] endTime, int[] profit){
        Job[] jobs = new Job[startTime.length];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs);
        int[][] res = new int[3][startTime.length];
        for (int i = 0; i < startTime.length; i++) {
            res[0][i] = jobs[i].startTime;
            res[1][i] = jobs[i].endTime;
            res[2][i] = jobs[i].profit;
        }
        return res;
    }

    public static void main(String[] Args) {
        Solution s  = new Solution();
        System.out.println(s.jobScheduling_stack(new int[]{43,13,36,31,40,5,47,13,28,16,2,11}, new int[]{44,22,41,41,47,13,48,35,48,26,21,39}, new int[]{8,20,3,19,16,8,11,13,2,15,1,1}));
        System.out.println(s.jobScheduling_DP(new int[]{43,13,36,31,40,5,47,13,28,16,2,11}, new int[]{44,22,41,41,47,13,48,35,48,26,21,39}, new int[]{8,20,3,19,16,8,11,13,2,15,1,1}));
    }
}