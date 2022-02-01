public class Solution {
     //O(n*m*log(n*m), n*m)
    //basic idea fill all in minheap, take out bth element
    public int solve(ArrayList<ArrayList<Integer>> A, int B) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        //fill all element in heap
        for(int i=0;i < A.size();i++){
            for(int j=0;j < A.get(0).size();j++){
                minheap.add(A.get(i).get(j));
            }
        }

        // take out B-1 elements
        for(int i=0;i < B-1;i++){
            minheap.poll();
        }
        // bth elements
        return minheap.peek();
    }
}
