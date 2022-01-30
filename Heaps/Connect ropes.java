public class Solution {
    public int solve(ArrayList<Integer> A) {
        //O(nlogn, n), as insertion and deletion in heap taken logn time, their are n elements
        // adding all to heap and then taking out keeping size atleat 1
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i=0;i < A.size();i++){
            heap.add(A.get(i));
        }

        int minSum=0;
        while(heap.size() != 1){
            int temp=heap.poll();
            temp = temp + heap.poll();
            //keeping cost
            minSum+=temp;
            // adding combined rope again into heap
            heap.add(temp);
        }
        return minSum;
    }
}
