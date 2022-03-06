public class Solution {
    //Dp memoization
    static int dp[][] = new int[1001][1001];
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
        //id dp has vaues for this i, j combinations return from here
        if(dp[i][j] != -1){
            return dp[i][j];
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
        dp[i][j] = minC;
        return minC;
    }
    public int solve(int[] A) {
        //100 as given constrains of array size
        for(int i=0;i < 1001;i++){
            for(int j=0;j < 1001;j++){
                dp[i][j] = -1;
            }
        }

        // selecting i as 1 cos i-1 index and i will give size of matrix, similarly j-1 index and j index will gice size of matrix nXm
        return selectingpairOfSizeikj(1, A.length-1, A);

    }
}