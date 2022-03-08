public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    //O(n, 1), xor of same element/number is 0, so inthe end number appearing once will be present
    public int singleNumber(final int[] A) {
        int res=0;
        for(int i=0;i < A.length;i++){
            res^=A[i];
        }
        return res;
    }
}
