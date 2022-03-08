public class Solution {
    //as sorted rowise, 1s will be in last, so starting from top right
    //it will return 1st row having max 1s
    public int solve(int[][] A) {
        int res=0;
        // starting from top right
        int i=0, j=A.length-1;
        starting
        int min = A.length;

        while(i < A.length && j >=0){
            //if 0 at i, j, go down so no 1 found
            if( A[i][j] == 0){
                i++;
            }
            else{
                // if 1 go left, till break j==0
                j--;
            }
            //store min j's row as res
            if(j < min){
                min=j;
                res=i;
            }
        }
        //return updated row
        return res;
    }
}
