public class Solution {
//O(d*log(3*d), d) d times addding into heap , size of heap 3 times d
//storing multiple into min heap taking out smallest adding multiple of 3 prime number into it
   public ArrayList < Integer > solve(int p1, int p2, int p3, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        ArrayList < Integer > res = new ArrayList < Integer >();
        minHeap.add(p1);
        minHeap.add(p2);
        minHeap.add(p3);
        res.add(minHeap.peek());

        while(res.size() < k){
            int smallestNum = minHeap.poll();
            //to avoid duplicates
            if(res.size() > 0 && res.get(res.size()-1) != smallestNum){
                res.add(smallestNum);
            }
            //adding all multiples
            minHeap.add(p1*smallestNum);
            minHeap.add(p2*smallestNum);
            minHeap.add(p3*smallestNum);
        }

        return res;
    }
}
