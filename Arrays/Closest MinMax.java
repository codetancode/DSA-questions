public class Solution {
    //O(n, 1)
    //idea is to find mina nd max first, then, traverse the array,
    // if min found check if left max is already found(update)
    // or if max found check if left min is already found(update)
    public int solve(int[] A) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // init index
        int lmin =-1;
        int lmax = -1;

        int i=0;
        int res = Integer.MAX_VALUE;
        //get min and max first
        for(i=0;i < A.length;i++){
            if(A[i] < min){
                min = A[i];
            }
            if(A[i] > max){
                max = A[i];
            }
        }

        //lmax and lmin storing the index
        for(i=0;i < A.length;i++){
            // if min found, check if we found left maximum
            if(A[i] == min){
                if(lmax != -1){
                    //if yes then update distance b/w left max(lmax) and current min(i)indexes(i - lmax + 1)
                    res = Math.min(res, i - lmax + 1);
                }
                //update lmin
                lmin = i;
            }

            // if min found, check if we found left maximum
            if(A[i] == max){
                if(lmin != -1){
                    //if yes then update distance b/w left min(lmin) and current max(i)indexes(i - lmin + 1)
                    res = Math.min(res, i - lmin + 1);
                }
                //update lmax
                lmax = i;
            }
        }

        return res;
    }
}
