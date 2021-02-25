public class segmentTree {
    int[] input;
    int[] sTree;
    segmentTree(int[] input){
        this.input = input;
        int len = input.length;
        if(len % 2 != 0){
            len = ((len<<1) & (-len));
        }
        sTree = new int[2*len - 1];
        //construct and fill the tree
        build(0, len-1, 0);
    }

    private void build(int l, int h, int pos){
        if(l == h){
            sTree[pos] = input[l];
            return;
        }
        int mid = (l+h)/2;
        build(l, mid, 2*pos+1);
        build(mid+1, h, 2*pos+2);
        sTree[pos] = sTree[2*pos+1] + sTree[2*pos+2];
    }

    public int query(int ql, int qh, int l, int h, int pos){
        // total overlap
        if(ql <= l && qh >= h){
            return sTree[pos];
        }
        // no overlap
        if(ql > h || qh < l){
            return 0;
        }

        int mid = (l+h)/2;
        return query(ql, qh, l, mid, 2*pos+1) + query(ql, qh, mid+1, h, 2*pos+2);
    }

    public void update(int l, int h, int idx, int val, int pos){
        if(idx < l || idx > h) return;
        if(l == h){
            input[idx] += val;
            sTree[pos] += val;
        } else {
            int mid = (l+h)/2;
            update(l, mid, idx, val, 2*pos+1);
            update(mid+1, h, idx, val, 2*pos+2);
            sTree[pos] = sTree[2*pos+1] + sTree[2*pos+2];
        }
    }


    public static void main(String[] Args){
        int[] input =  new int[]{1,2,3,4};
        segmentTree s = new segmentTree(input);
        System.out.println(s.sTree.length);
        System.out.println(s.query(1, 3, 0, 3, 0));
        s.update(0, 3, 3, 8, 0);
        System.out.println(s.query(3, 3, 0, 3, 0));
    }
}
