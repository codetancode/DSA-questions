public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        //Brute force - O(n2, n)
        //idea is to keep max N possible sum from both elements A, B into min heap of size N,
        // if found bigger replace top element
        int n = A.size();
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> minheap = new PriorityQueue<>(n);
        //n2 for finding and storing sum
        for(int i=0;i < A.size();i++){
            for(int j=0;j < A.size();j++){
                if(minheap.size() < n){
                    minheap.add(A.get(i)+B.get(j));
                }else{
                //if new element is big, replace with top of min heap, maintaining n elements in heap
                    if(A.get(i)+B.get(j) > minheap.peek()){
                        minheap.poll();
                        minheap.add(A.get(i)+B.get(j));
                    }
                }

            }
        }
        //storing elements in required orders
        for(int i=0;i < A.size();i++){
            res.add( 0, minheap.poll());
        }
        return res;
    }
}
