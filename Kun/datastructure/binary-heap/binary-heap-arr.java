import java.util.Queue;
import java.util.ArrayDeque;

class maxBinaryHeap_arr{
    int[] binMaxHeap;
    int lastNodeIdx;
    maxBinaryHeap_arr(int size){
        this.binMaxHeap = new int[size];
        this.lastNodeIdx = -1;
    }

    int parent(int i) {
        return (i-1)/2;
    }

    int left(int i){
        return (2*i +1);
    }

    int right(int i){
        return 2*i+2;
    }

    void swap(int i, int j){
        int temp = binMaxHeap[i];
        binMaxHeap[i] = binMaxHeap[j];
        binMaxHeap[j] = temp;
    }

    void insert(int val) throws Exception{
        if(lastNodeIdx == binMaxHeap.length-1){
            throw new Exception("Heap has reached its capacity!");
        }
        lastNodeIdx++;
        binMaxHeap[lastNodeIdx] = val;
        int i = lastNodeIdx;
        while (i > 0){
            int pIdx = parent(i);
            if(binMaxHeap[i] > binMaxHeap[pIdx]) swap(i, pIdx);
            else break;
            i = pIdx;
        }
    }

    void heapify(int i) {
        while(i < lastNodeIdx){
            int l = left(i);
            int r = right(i);
            int largestIdx = i;
            if(l <= lastNodeIdx && binMaxHeap[largestIdx] < binMaxHeap[l]) {
                largestIdx = l;
            }
            if(r <= lastNodeIdx && binMaxHeap[largestIdx] < binMaxHeap[r]){
                largestIdx = r;
            }
            if(largestIdx != i) {
                swap(i, largestIdx);
                i = largestIdx;
            } else {
                break;
            }
        }
    }

    int getMax(){
        return binMaxHeap[0];
    }

    int extractMax(){
        int curRoot = binMaxHeap[0];
        swap(0, lastNodeIdx);
        lastNodeIdx--;
        heapify(0);
        return curRoot;
    }

    void remove(int key) throws Exception{
        try {
            int idx = search(key);
            swap(idx, lastNodeIdx);
            lastNodeIdx--;
            heapify(idx);
        } catch(Exception e) {
            throw e;
        }
    }

    int search(int key) throws Exception{
        int i = 0;
        // Do a BFS using queue
        Queue<Integer> Q = new ArrayDeque<>();
        Q.add(i);
        while(!Q.isEmpty()){
            i = Q.poll();
            if (key == binMaxHeap[i]){
                return i;
            }
            if (key < binMaxHeap[i]){
                if (left(i) <= lastNodeIdx) Q.add(left(i));
                if (right(i) <= lastNodeIdx) Q.add(right(i));
            }
        }
        throw new Exception("No such key found");
    }

    public static void main(String[] Args){
        maxBinaryHeap_arr h = new maxBinaryHeap_arr(10);
        try{
            h.insert(1);
            h.insert(2);
            h.insert(3);
            h.insert(4);
            h.insert(5);
            h.remove(5);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(h.getMax());
        while(h.lastNodeIdx != -1){
            System.out.println(h.extractMax());
        }
    }
}
