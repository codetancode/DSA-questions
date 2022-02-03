public class Solution {
    // O(nlogn, n), n space becoz of heap
    //idea is to create pair values pair sum, a index and b index
    //sort both the arrays in O(nlogn)
    //stor all pair having n-1 fix index of A and all of B index into max heap(O(n))
    //latter in loop removing max and adding, n-2, n-3.. index of A and ith index of B(O(n)) till wee reach required no. of pairs
    class Pair{
       int aindex;
       int bindex;
       int sum;
       Pair(int sum ,int a, int b){
            this.sum = sum;
           this.aindex = a;
           this.bindex = b;
       }
    }
    //comparator class for maxheap of pairs
    class HelperCompare implements Comparator<Pair>{
        public int compare(Pair n1, Pair n2){
            //will create max heap
            return n2.sum-n1.sum;
        }
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        //idea is to keep max N possible sum from both elements A, B into min heap of size N,
        // if found bigger replace top element
        int n = A.size();
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Pair> maxheap = new PriorityQueue<>(new HelperCompare());

        //sort boht in nlogn
        Collections.sort(A);
        Collections.sort(B);

        //pair sum by fixing max of A(n-1) with all n of B in a heap
        for(int i=0;i < B.size();i++){
            maxheap.add(new Pair(A.get(n-1)+B.get(i), n-1, i));
        }

        //n for finding and storing sum
        while(res.size() < n){
            //pooling max and putting updated index pair sum in max heap
            Pair maxPair = maxheap.poll();
            res.add(maxPair.sum);
            int aindex = maxPair.aindex;
            int bindex = maxPair.bindex;
            //to avoid 0-1 index reference of array of size 1 in trest case
            if(res.size() == n){
                break;
            }
            //to avoid 0-1 index reference of array of size 1 in trest case
            // putting updated index pair into heap, indexes of a with fixed index of B
            maxheap.add(new Pair(A.get(aindex-1)+B.get(bindex), aindex-1, bindex));
        }
        return res;
    }
}
