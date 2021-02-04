public class node {
    int val;
    int rank;
    node parent;
    node(int val,int rank){
        this.val = val;
        this.rank = rank;
        this.parent = this;
    }
}
