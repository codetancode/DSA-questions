public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        //idea is to keep heap of elements
        // takeout minimin then add -ve of that again into heap B times,
        // then take sum
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int sum=0;
        //put all in heap
        for(Integer i:A){
            heap.add(i);
        }
        // pull and push -ve of min value into heap B times
        while(B > 0){
            int temp = heap.poll();
            heap.add(-(temp));
            B--;
        }
        // take sum of remaining
        while(!heap.isEmpty()){
            sum += heap.poll();
        }

        return sum;

    }
}
