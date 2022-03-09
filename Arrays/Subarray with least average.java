public class Solution {
    //least average meanse least sum of a sub array, keeping a window of size B and tterating over the array, updating min sum
    public int solve(int[] A, int B) {
        int s=0;
        int i=0;
        int res = -1;
        int min = Integer.MAX_VALUE;
        //summing first B elements
        for(i=0;i < B;i++){
            s += A[i];
        }
        //updating result
        if(s < min){
            min = s;
            res = 0;
        }
        //iterating over the array with window size B,
        // reducing left adding right and checking
        for(i=0;i < A.length-B;i++){
        // reducing left adding right and checking
            s-=A[i];
            s+=A[B+i];

            if(s < min){
                min = s;
                res=i+1;
            }
        }

        return res;
    }
}
