public class Solution {
    public int nchoc(int A, ArrayList<Integer> B) {
        // O(nlogn, n)
        //idea is simple add all in max heap, take out max bag of chocolate keep sum,
        //add /2(floor) of it into maxheap again
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        long eaten = 0;
        int mod = 1000000007;//mod value given in qstn
        //add all in max heap
        for(Integer i:B){
            maxheap.add(i);
        }
        //take out b time max bag of chocolate, and put /2(floor) of it again
        for(int i=0;i < A;i++){
            int maxChocBag = maxheap.poll();
            eaten = (eaten%mod + maxChocBag%mod)%mod;
            maxheap.add((maxChocBag/2));
        }
        //return sum of taken out
        return (int)eaten;

    }
}
