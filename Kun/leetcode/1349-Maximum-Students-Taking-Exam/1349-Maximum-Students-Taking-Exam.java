import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
        int m, n;
        //ArrayList<Integer>[] adj;
        int[][] dirs = new int[][]{{0,1},{0,-1},{-1,-1},{-1,1},{1,1},{1,-1}};
        int stCt = 0;
        int mf;
        int sc, sk, V;
        // residual map
        int[][] capacity;
        public int maxStudents(char[][] seats) {
            // Using maximum flow BK algorithm
            // time complexity: O(VEE)
            // partition matrix into odd and even
    
            //init graph
            initG(seats);
            EK();
            return stCt - mf;
        }
    
        private void EK(){
            int[] parent = new int[V];
            int flow = bfs(parent);
            while(flow > 0){
                mf += flow;
                int start = -1, end = sk;
                while(start != sc){
                    start = parent[end];
                    capacity[start][end] -= flow;
                    capacity[end][start] += flow;
                    end = start;
                }
                flow = bfs(parent);
            }
        }
    
        private int bfs(int[] parent){
            Arrays.fill(parent, -1);
            parent[sc] = -2;
            Queue<Integer>  q = new LinkedList<>();
            q.add(sc);
            while(!q.isEmpty()){
                int cn = q.poll();
                for(int nn = 0; nn < V; nn++){
                    if(parent[nn] == -1 && capacity[cn][nn] > 0){
                        parent[nn] = cn;
                        if(nn == sk) return 1;
                        q.add(nn);
                    }
                }
                // for(int nn: adj[cn]){
                //     if(parent[nn] == -1 && capacity[cn][nn] > 0){
                //         parent[nn] = cn;
                //         if(nn == sk) return 1;
                //         q.add(nn);
                //     }
                // }
            }
            return 0;
        }
    
        private void initG(char[][] seats){
            this.m = seats.length;
            this.n = seats[0].length;
            // where m*n is source and m*n + 1 is sink
            V = m*n + 2;
            sc = m*n;
            sk = m*n+1;
            mf = 0;
            capacity = new int[V][V];
            // for(int i = 0; i < V; i++){
            //     Arrays.fill(capacity[i],1);
            // }
            //adj = new ArrayList[V];
            // for(int i = 0; i < V; i++){
            //     adj[i] = new ArrayList<>();
            // }
    
            for(int i = 0; i < m; ++i){
                for(int j = 0; j < n; ++j){
                    if(seats[i][j] == '#') continue;
                    stCt++;
                    if(j%2 == 0){
                        //adj[sc].add(i*n+j);
                        capacity[sc][i*n+j] = 1;
                        for(int[] dir: dirs){
                            int ni = i + dir[0];
                            int nj = j + dir[1];
                            if(ni < 0 || ni >= m || nj < 0 || nj >= n || seats[ni][nj] == '#') continue;
                            //adj[i*n+j].add(ni*n+nj);
                            capacity[i*n+j][ni*n+nj] = 1;
                        }
                    } else {
                        //adj[i*n+j].add(sk);
                        capacity[i*n+j][sk] = 1;
                    }
                }
            }
            // for(int i = 0; i < V; i++){
            //     adj[i].sort((x,y) -> (x-y));;
            // }
        }

        public static void main(String[] Args){
            Solution s = new Solution();
            char[][] seats = new char[][]{
                {'#','.','#','#','#'},
                {'#','.','.','.','.'},
                {'#','.','.','.','.'},
                {'.','#','.','.','.'}
            };
            System.out.println(s.maxStudents(seats));
        }
    }