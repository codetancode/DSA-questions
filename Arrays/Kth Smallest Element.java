public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    // O(B*n, 1) selections sort
    public int kthsmallest(final int[] A, int B) {
        //for first B numbers look for min numbers
        for(int i=0;i < B;i++){
            int min = Integer.MAX_VALUE;
            int minInd = -1;
            for(int j=i;j < A.length;j++){
                // finding min from i to n
                if(A[j] < min){
                    min = A[j];
                    minInd = j;
                }
            }
            //got min from index i to the length
            //swap 1st smallest number to 1st position
            int t=min;
            A[minInd] = A[i];
            A[i] = t;

        }
        // as till B elements array is sorted, so return B-1 index
        return A[B-1];
    }
}
