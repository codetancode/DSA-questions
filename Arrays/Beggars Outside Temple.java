public class Solution {
    //O(n, 1)
    //concept is ploting and using prefix sum in Oderes n, to get result
    public int[] solve(int A, int[][] B) {
        int[] res = new int[A];

        //ploting at index
        for(int i=0;i < B.length;i++){
            int l = B[i][0]-1;
            int r = B[i][1]-1;

            //ploting 1st
            res[l] += B[i][2];
            //checking if next exist then reduce
            if(r+1 < A){
                res[r+1] -= B[i][2];
            }

        }
        //pfsum
        for(int i=1;i < A;i++){
            res[i] = res[i] + res[i-1];
        }
        return res;
    }
}
