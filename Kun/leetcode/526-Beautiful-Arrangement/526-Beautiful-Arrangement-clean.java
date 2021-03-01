import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Solution2 {
    int count = 0;
    int n;
    public int countArrangement(int n) {
        this.n = n;
        boolean[] visited = new boolean[n+1];
        helper(visited, 1);
        return count;
    }

    private void helper(boolean[] visited, int s){
        if(s > n) {count++;return;}
        for(int i = 1; i <= n; i++){
            if(!visited[i] && (s%i == 0 || i%s == 0)){
                visited[i] = true;
                helper(visited, s+1);
                visited[i] = false;
            }
        } 
    }

    public static void main(String[] Args){
        Solution2 s = new Solution2();
        System.out.println(s.countArrangement(10));
    }
}