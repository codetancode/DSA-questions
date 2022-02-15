public class Solution {
    //idea is to store all i(p)(0 to n-1)/n-1(q) into minheap as the array is sorted, then keep checking
    // and adding q in loop if q-1 becomes greater than p
     class Pair{
        int p;
        int q;
        double fraction;
        Pair(int p, int q, double fraction){
            this.p = p;
            this.q=q;
            this.fraction = fraction;
        }
    }

    class HelperComp implements Comparator<Pair>{
        public int compare(Pair n1, Pair n2){
                    return Double.compare(n1.fraction, n2.fraction);
                }
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Pair> minheap= new PriorityQueue<>(new HelperComp());
        int n = A.size();

        //storing p(0 to n-1 index)/q(n-1 index) into heap
        for(int i=0;i < n-1;i++){
            minheap.add(new Pair(i, n-1, 1D*A.get(i)/A.get(n-1)));
        }
        //for B minimum fraction
        while(B != 1){
            Pair smallestFrac = minheap.poll();
            // if n-2, n-3.. > p(0 to n-1 index values) then the fraction would become bigger
            // so use q-1, 1-2, .. n-2, n-3.. denominator
            if( (smallestFrac.q - 1) > smallestFrac.p){
                double fraction = 1D*A.get(smallestFrac.p)/A.get(smallestFrac.q-1);
                // add new small fraction of found p/q-1 into heap
                minheap.add(new Pair(smallestFrac.p, smallestFrac.q-1, fraction));
            }
            B--;
        }

        //take out Bth pair fraction of, and return p and q of that
        Pair BthPair = minheap.poll();
        return new ArrayList<>( Arrays.asList(A.get(BthPair.p), A.get(BthPair.q)) );
    }
}
