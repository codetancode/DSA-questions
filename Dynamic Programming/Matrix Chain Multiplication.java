public class Solution {
    //simple recursive function
    //moving from i to j using k, picking up temprary ans, andd returning min of it,
    //base condition if i>=j, considering size of matrix
    //so considering [i-1, i] a matrix size
    //and [j-1, j] a matrix size, moving k for all possible answers from k=i to k=j-1 index

    int selectingpairOfSizeikj(int i, int j, int[] A){
        //base condition
        if(i >= j){

            //now for this selection getting ans from i to k and k+1 to j-1 + cost of joining these 2 matrix size
            return 0;
        }
        int minC = Integer.MAX_VALUE;
        //taking gtom i=k to k=j
        for(int k=i;k <= j-1;k++){
             //so considering [i-1, i] a matrix size
            //and [j-1, j] a matrix size, moving k for all possible answers from k=i to k=j-1 index
            //now for this selection getting ans from i to k and k+1 to j-1 + cost of joining these 2 matrix size
            int tempAns = selectingpairOfSizeikj(i, k, A) + selectingpairOfSizeikj(k+1, j, A) + A[i-1]*A[k]*A[j];

            minC = Math.min(minC, tempAns);
        }
        return minC;
    }
    public int solve(int[] A) {
        // selecting i as 1 cos i-1 index and i will give size of matrix, similarly j-1 index and j index will gice size of matrix nXm
        return selectingpairOfSizeikj(1, A.length-1, A);

    }
}