public class Solution {
    //O(n, n) solution optimized
    //3 arryas of max maintained solution, i<=j<=k,
    public int solve(ArrayList<Integer> A, int B, int C, int D) {
        //finding premax by take it or leave it concept for all 3 terms
        //3 loops to fill considering previous premax array values
        // A[i]*B,
        ArrayList<Integer> premax = new ArrayList<Integer>();
        // (A[i]*B) + A[j]*C,
        ArrayList<Integer> premax2 = new ArrayList<Integer>();
        //  (A[i]*B+A[j]*C) + A[k]*D
        ArrayList<Integer> premax3 = new ArrayList<Integer>();
        //adding all min into them for ref.
        premax.add(Integer.MIN_VALUE);
        premax2.add(Integer.MIN_VALUE);
        premax3.add(Integer.MIN_VALUE);

        // A[i]*B or prev max
        for(int i=0;i < A.size();i++){
// as premax array size is +1 due to ref value added, prev is i, and current is i+1 in premax, i is current for A
                                    // A[i]*B or prev max
            premax.add(Math.max(A.get(i)*B, premax.get(i)));
        }

        for(int i=0;i < A.size();i++){
                                // prev A[i]*B or current A[i]*B +  A[j]*C
            premax2.add(Math.max(premax2.get(i), premax.get(i+1)+A.get(i)*C));
        }

        for(int i=0;i < A.size();i++){
                            // prev A[i]*B+A[j]*C or current A[i]*B+A[j]*C +  A[k]*D
            premax3.add(Math.max(premax3.get(i), premax2.get(i+1)+A.get(i)*D));
        }

        //last index of last array will have max sum,
        // as we have maintained max sum throughout 3 arrays
        return premax3.get(premax.size()-1);
    }

}
