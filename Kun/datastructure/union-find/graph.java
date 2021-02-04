import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class graph{
    private Map<node, ArrayList<node>> adj;

    graph(){
        this.adj = new HashMap<>();
    }

    public Map<node, ArrayList<node>> getAdj(){
        return this.adj;
    }

    public void addEdge(node i, node j){
        if(adj.containsKey(i)) {
            adj.get(i).add(j);
        } else {
            adj.put(i, new ArrayList<node>(Arrays.asList(j)));
        }
    }
}