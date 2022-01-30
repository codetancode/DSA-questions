public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        //add b+1 elements into minheap till we fill heap with all array elements, empty arry elements
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        ArrayList<Integer> res = new ArrayList<Integer>();

        //as k places apart, so till B+1
        for(int i=0;i <= B;i++){
            minheap.add(A.get(i));
        }
        //fill all array elements in heap
        while(B+1 < A.size()){
            res.add(minheap.poll());
            minheap.add(A.get(B+1));
            B++;
        }
        //empty heap to make a size of req array A
        while(!minheap.isEmpty()){
            res.add(minheap.poll());
        }

        return res;

    }
}
