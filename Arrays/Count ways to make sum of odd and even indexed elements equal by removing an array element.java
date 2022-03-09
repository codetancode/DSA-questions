public class Solution {
    //O(n, 1)
    //as we need to make even index sum and odd index sum =,
    // so keeping 4 variables right even and left even, right odd and left odd sum
    public int solve(int[] A) {
        int r_evs =0;
        int r_odds =0;
        int l_evs =0;
        int l_odds =0;
        int res=0;
        int i=0;

        //first filling right even and odd sum
        for(i=0;i < A.length;i++){
            if((i&1) == 0){
                r_evs+=A[i];
            }
            else{
                r_odds+=A[i];
            }
        }
        //now as we go we will fill left even and odd sum and decrease right even and odd sum
        for(i=0;i < A.length;i++){
            //first decreasing right sums(even or odd)
            if((i&1) == 0){
                r_evs -= A[i];
            }
            else{
                r_odds -= A[i];
            }

            //now checking if we found a point(i) where ( left even and right odd ) are same as (left odd and right even)
            if( l_evs + r_odds == l_odds + r_evs ){
                //if found such point update res
                res++;
            }

            //also keep adding left(odd even sum)
            if((i&1) == 0){
                l_evs += A[i];
            }
            else{
                l_odds += A[i];
            }

        }

        return res;
    }
}
