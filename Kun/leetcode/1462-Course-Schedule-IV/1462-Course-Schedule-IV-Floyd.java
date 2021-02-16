import java.util.List;
import java.util.ArrayList;

class Solution3 {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean[][] connected = new boolean[n][n];
        int len = prerequisites.length;
        for(int i = 0; i < len; i++){
            connected[prerequisites[i][0]][prerequisites[i][1]] = true;
        }

        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    connected[i][j] = connected[i][j] || (connected[i][k] && connected[k][j]);
                }
            }
        }

        List<Boolean> res = new ArrayList<>();
        for(int[] query: queries){
            res.add(connected[query[0]][query[1]]);
        }

        return res;
    }
}