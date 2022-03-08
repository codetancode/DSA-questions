public class Solution {
    //O(nlogn, 1)
    public int solve(int[] A) {
        int i=0;
        //sort and check if element is != len-i difference and nodupilcates so A[i] != A[i+1]
        Arrays.sort(A);
        for(i=0;i < A.length-1;i++){
            if(A[i] == (A.length-i-1) && A[i]!=A[i+1]){
                return 1;
            }
        }
        if(A[A.length-1]==0){
            return 1;
        }
        return -1;
    }
}
