public class Solution {
    //using boolean checks for odd and even element
    public int solve(int[] A) {
        int res = 0;
        int i=0;
        boolean od = true;
        boolean ev = true;

        while(i < A.length){
            // if current element is even and odd is already found(true)
            if( (A[i]&1) != 1 && od ){
                //mark even found, and odd false
                ev = true;
                od = false;
                res++;
            }
            //if curr element is odd and even is already found(true)
            if( (A[i]&1) == 1 && ev ){
                //mark odd as true, and even as false
                od = true;
                ev = false;
                res++;
            }
            i++;

        }
        return res;

    }
}
