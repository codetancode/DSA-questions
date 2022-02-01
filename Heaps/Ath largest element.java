public class Solution {
    public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
        // Ath largest is nothing but Ath smallest in A numbers, use a min heap of size a, root will have ath largest
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(A);
        ArrayList<Integer> res = new ArrayList<Integer>();
        //first A elements in heap
        for(int i=0;i < A;i++){
            minHeap.add(B.get(i));
            // as 0 based indexing
            if(i < A-1){
                res.add(-1);
            }else{
                res.add(minHeap.peek());
            }
        }

        // rest of the elements, if new element is bigger than smallest in heap, replace(keeping size of heap A)
        for(int i=A;i < B.size();i++){
            if(minHeap.peek() < B.get(i)){
                minHeap.poll();
                minHeap.add(B.get(i));
            }
            res.add(minHeap.peek());
        }
        return res;
    }
}
