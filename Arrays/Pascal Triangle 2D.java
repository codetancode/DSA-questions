public class Solution {
    public int[][] solve(int A) {
        // O(n^2, 1) as constrution 2d array is output only
        //idea is diagonal left + top for every element
        int[][] res = new int[A][A];

        if(A==0) {

            int[][] ans = {};

            return ans;

        }
        //setting 1st as rest are 0 already
        res[0][0] = 1;
        //starting from 2nd row
        for(int i=1;i < A;i++){
            // first value
            for(int j=0;j <= i;j++){
                //from 2nd element in next row is diagonal left + top
                if(j >= 1){
                    res[i][j] = res[i-1][j-1] + res[i-1][j];
                }//for 1st element in next rowj==0
                else{
                    res[i][j]=1;
                }
            }
        }

        return res;
    }
}
