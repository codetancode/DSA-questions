public class Solution {
    // O(max(n, m)*logn, B)
    //reducing space by using max heap of size B
    public int solve(ArrayList<ArrayList<Integer>> A, int B) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(B, Collections.reverseOrder());
        //fill elements in max heap
        //reducing Space to B
        for(int i=0;i < A.size();i++){
            for(int j=0;j < A.get(0).size();j++){
                if(maxheap.size() < B){
                    maxheap.add(A.get(i).get(j));
                }else{
                    // for extra size, check if new element is less than current max
                    if(maxheap.peek() > A.get(i).get(j)){
                        // replace, keeping B elements in heap
                        maxheap.poll();
                        maxheap.add(A.get(i).get(j));
                    }
                }
            }
        }
        // bth smalles element
        return maxheap.peek();
    }
}
