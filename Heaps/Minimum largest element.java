public class Solution {
    // putting added values of the element into a heap pair(added val, orignal index)
    // keep picking small element and then add original val(with help of original index) into heap
    //updating state of array A, with the help of index
    //in the end pick max from array A

    //creating a helper Pair class and implement its compare class to store in heap
    static class Pair{
        int index;
        int val;
        Pair(int val, int index){
            this.index = index;
            this.val = val;
        }
    }
    //to compare Pair obj(for heap)
    class CompPair implements Comparator<Pair>{
        public int compare(Pair a, Pair b){
            // just the difference based on val
            return a.val-b.val;
        }
    }

    public int solve(ArrayList<Integer> A, int B) {
        //creating a PriorityQueue that takes Pair object and its comparable class instance
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(new CompPair());
        int max = Integer.MIN_VALUE;
        //making a original copy for reference(for adding in opration)
        ArrayList<Integer> original = new ArrayList<>(A);

        // adding double values as Pair with original index into heap
        for(int i=0;i < A.size();i++){
            minHeap.add(new Pair(2*A.get(i), i));
        }

        // for B operations, takeout min, update state of A(that perticular index value),
        // add it back with added values using original index and original array for reference
        for(int i=0;i < B;i++){
            Pair minPair = minHeap.poll();
            A.set(minPair.index, minPair.val);
            minHeap.add(new Pair(minPair.val + original.get(minPair.index), minPair.index));
        }
        //get max from array A
        for(int i=0;i < A.size();i++){
            max=Math.max(max, A.get(i));
        }
        return max;
    }
}
