class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int balance = 0, remain = 0;
        int start = 0;
        for(int i = 0; i < n; i++){
            balance += gas[i] - cost[i];
            remain += gas[i] - cost[i];
            if(remain < 0){
                start = i + 1;
                remain = 0;
            }
        }
        return balance < 0 ? -1: start;
    }
}