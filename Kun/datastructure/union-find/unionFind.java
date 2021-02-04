import java.util.Map;
import java.util.ArrayList;

public class unionFind {

    // find the root of every node
    public node find(node x){
        node root = x;
        // find the actual root
        while(root.parent != root){
            root = root.parent;
        }
        while(x.parent != root) {
            node parent = x.parent;
            x.parent = root;
            x = parent;
        }
        return  root;
    }

    public node union(node x, node y){
        x = find(x);
        y = find(y);

        if (x == y) return x;
        if (x.rank > y.rank) {
            node temp = x;
            x = y;
            y = temp;
        }

        x.parent = y;
        if(x.rank == y.rank) y.rank++;
        return y;
    }

    public static void main(String[] Args){
        graph g = new graph();
        node n1 = new node(0, 0);
        node n2 = new node(1, 0);
        node n3 = new node(2, 0);
        g.addEdge(n1, n2);
        g.addEdge(n2, n3);
        g.addEdge(n3, n1);
        unionFind u = new unionFind();
        
        Map<node, ArrayList<node>> adj = g.getAdj();
        for(Map.Entry<node, ArrayList<node>> mapEle: adj.entrySet()){
            ArrayList<node> dests = mapEle.getValue();
            node src = mapEle.getKey();
            for(node dest: dests){
                u.union(src, dest);
            }
        }

        System.out.println(u.find(n1) == u.find(n2) && u.find(n2) == u.find(n3));
    }

}
