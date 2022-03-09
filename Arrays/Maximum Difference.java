public class Solution {
    public int solve(int[] A, int B) {
        //sorting the array first in nlogn
        Arrays.sort(A);

        int tillb=0;
        int rest=0;
        //now optimizing if B is more than half len
        if(B > (A.length/2)){
            //from last
            for(int i=A.length-1;i >= 0;i--){
                // considering B to len as a section/subset (tillB)
                if(i > A.length-B-1){
                    tillb +=A[i];
                }else{
                    //and 0 to B as rest
                    rest += A[i];
                }
            }
        }
        else{
            //from start
            for(int i=0;i < A.length;i++){
                //consdering 0 to B a section/subset as (tillB)
                if(i < B){
                    tillb += A[i];

                }else{
                    //from b to len as rest subset/section
                    rest += A[i];
                }
            }
        }

        //returning abs diff
        return Math.abs(rest-tillb);
    }
}
