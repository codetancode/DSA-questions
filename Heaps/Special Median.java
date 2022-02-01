public class Solution {
        static int flag = 0;
        void checkMedForth(ArrayList<Integer> A){
            //using the median in running stream using max heap fro 1st half and min heap for the next half
            PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minheap = new PriorityQueue<>();

            // keeping 1+ element in 1st half max heap, so
            // if maxheap.size()>minheap, median is root of maxheap(odd elements)
            // if both size are ==, median is avg of both roots of max and min heap
            double currMed = 0;
            for(int i=0;i < A.size()-1;i++){
                int newElem = A.get(i);

                if(maxheap.isEmpty() || maxheap.peek() > newElem){
                    maxheap.add(newElem);
                    //if imbalance
                    if(maxheap.size()-minheap.size() > 1){
                        minheap.add(maxheap.poll());
                    }
                }else{
                    minheap.add(newElem);
                    //if imbalance
                    if(maxheap.size() < minheap.size()){
                        maxheap.add(minheap.poll());
                    }
                }
                //median if odd numbers the just root of maxhead(coz max heap has 1 more element),
                //else avg of both root
                if(maxheap.size() > minheap.size()){
                    currMed = maxheap.peek();
                }else{
                    //double and floor for some test cases
                    currMed = Math.floor(maxheap.peek() + minheap.peek())/2;
                }
                // for test case
                // 2147483647 -2147483648 0, median comming 0
                // System.out.println(currMed+" "+A.get(i+1));
                //if next element is current med
                if(A.get(i+1) == currMed){
                    flag=1;
                }
            }
        }

    public int solve(ArrayList<Integer> A) {
        flag=0;
        //first checkMedForth then revers and then also check for flag
        checkMedForth(A);
        Collections.reverse(A);
        checkMedForth(A);

        return flag;
    }
}
