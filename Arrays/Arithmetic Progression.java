public class Solution {
    public int solve(int[] A) {
        //sort and check subsequent difference is 1 or not
        Arrays.sort();
        int diff = A[1] - A[0];
        int i=1;
        while(i < A.length){
            if(A[i]-A[i-1] != diff){
                return 0;
            }
            i++;
        }
        return 1;
    }
}
