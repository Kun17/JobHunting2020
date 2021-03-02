// Given a word of length n and n six-sided dice with a character in each side. Find out if this word can be constructed by the set of given dice.

// Example 1:

// Input:
// word = "hello"
// dice = [[a, l, c, d, e, f], [a, b, c, d, e, f], [a, b, c, h, e, f], [a, b, c, d, o, f], [a, b, c, l, e, f]]
// Output: true
// Explanation: dice[2][3] + dice[1][4] + dice[0][1] + dice[4][3] + dice[3][4]
// Example 2:

// Input:
// word = "hello"
// dice = [[a, b, c, d, e, f], [a, b, c, d, e, f], [a, b, c, d, e, f], [a, b, c, d, e, f], [a, b, c, d, e, f]]
// Output: false
// Example 3:

// Input:
// word = "aaaa"
// dice = [[a, a, a, a, a, a], [b, b, b, b, b, b], [a, b, c, d, e, f], [a, b, c, d, e, f]]
// Output: false

import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

class Solution2 {
    ArrayList<Integer>[] adj;
    int[][] capacity;
    Set<Character>[] diceSet;
    int n, V;
    public boolean canConstructWord(String word, char[][] dice){
        //Edmonds-Karp algorithm, O(VEE)
        // Space: O(VV)
        // 1st we need to build the graph
        // 0 is the source, and 2n+1 is the sink
        // 1-n are word char
        // n+1 - 2n are dice

        // Map initialization
        initMap(word, dice);
        int[] parent = new int[V];
        int flow = 0;
        int minFlow = bfs(0, V-1, parent);
        while(minFlow > 0){
            flow += minFlow;
            int start = V-1, end = V-1;
            while(start != 0){
                start = parent[end];
                capacity[start][end] -= minFlow;
                capacity[end][start] += minFlow;
                end = start;
            }
            minFlow = bfs(0, V-1, parent);
        }
        return flow == n;
    }

    private int bfs(int s, int e, int[] parent){
        Arrays.fill(parent, -1);
        parent[0] = -2;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{s, Integer.MAX_VALUE});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cn = cur[0];
            int cf = cur[1];
            for(int nn: adj[cn]){
                if(parent[nn] == -1 && capacity[cn][nn] > 0){
                    parent[nn] = cn;
                    int nf = Math.min(capacity[cn][nn], cf);
                    if(nn == e) return nf;
                    q.add(new int[]{nn, nf});
                }
            }
        }
        return 0;
    }

    private void initMap(String word, char[][] dice){
        n = dice.length;
        V = 2*n+2;
        adj = new ArrayList[V];
        capacity = new int[V][V];
        diceSet = new Set[n];
        for(int i = 0; i < V; i++){
            Arrays.fill(capacity[i],1);
        }
        for(int i = 0; i < n; i++){
            diceSet[i] = new HashSet<>();
            for(int j = 0; j < 6; j++){
                diceSet[i].add(dice[i][j]);
            }
        }
        for(int i = 0; i < V; i++){
            adj[i] = new ArrayList<>();
        }
        // Add adj to source and 1-n word node
        for(int i = 1; i <= n; i++){
            adj[0].add(i);
            for(int j = n+1; j <= 2*n; j++){
                if(diceSet[j-n-1].contains(word.charAt(i-1))){
                    adj[i].add(j);
                }
            }
        }
        for(int i = n+1; i <= 2*n; i++){
            adj[i].add(2*n+1);
        }
    }

    public static void main(String[] Args){
        Solution2 s = new Solution2();
        // 6 7 8 9 10
        char[][] dice = new char[][]{
            {'a', 'l', 'c', 'd', 'e', 'f'}, 
            {'a', 'b', 'c', 'd', 'e', 'f'}, 
            {'a', 'b', 'c', 'h', 'e', 'f'}, 
            {'a', 'b', 'c', 'd', 'o', 'f'}, 
            {'a', 'b', 'c', 'l', 'e', 'f'}
        };
        // 0 1 2 3 4
        // 1 2 3 4 5
        String word = "helao";
        System.out.println(s.canConstructWord(word, dice));
        // s = new Solution2();
        // dice = new char[][]{
        //     {'a', 'l', 'c', 'd', 'e', 'f'}, 
        //     {'a', 'b', 'c', 'd', 'e', 'f'}, 
        //     {'a', 'b', 'c', 'h', 'e', 'f'}, 
        //     {'a', 'b', 'c', 'd', 'o', 'f'}, 
        //     {'a', 'b', 'c', 'l', 'e', 'f'}
        // };
        // word = "hello";
        // System.out.println(s.canConstructWord(word, dice));
        // s = new Solution2();
        // dice = new char[][]{
        //     {'a', 'a', 'a', 'a', 'a', 'a'}, 
        //     {'b', 'b', 'b', 'b', 'b', 'b'}, 
        //     {'a', 'b', 'c', 'd', 'e', 'f'}, 
        //     {'a', 'b', 'c', 'd', 'e', 'f'}
        // };
        // word = "aaaa";
        // System.out.println(s.canConstructWord(word, dice));
    }
}
