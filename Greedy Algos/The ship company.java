public class Solution {
    //O(n*logn, n) greedy
    //idea is to srore vacancies into heaps min and max, and maintain them for A passengers.
    //for max const take out from maxHeap, and add -1 into it again if not 0, for min take out min and add -1 back if not 0
    public ArrayList<Integer> solve(int A, int B, ArrayList<Integer> C) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        PriorityQueue<Integer> maxheap = new PriorityQueue<>();
        PriorityQueue<Integer> minheap = new PriorityQueue<>(Collections.reverseOrder());
        int max = 0;
        int min = 0;
        //filling both heaps with cost values nlogn
        for(int i=0;i < C.size();i++){
            maxheap.add(C.get(i));
            minheap.add(C.get(i));
        }
        //for a passengers, calculating max
        for(int i=0;i < A;i++){
            int maxVacCost = maxheap.poll();
            max += maxVacCost;
            //if not 0 then only add
            if(maxVacCost-1 != 0){
                maxheap.add(maxVacCost-1);
            }
        }

        //for a passengers, calculating min
        for(int i=0;i < A;i++){
            int minVacCost = minheap.poll();
                min += minVacCost;
                //if not 0 then only add
                if(minVacCost-1 != 0){
                    minheap.add(minVacCost-1);
                }
        }

        res.add(min);
        res.add(max);
        return res;
    }
}
