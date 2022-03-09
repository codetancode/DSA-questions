public class Solution {
    //so idea is sorting w.r.t heights then finding longestIncreasingSubsequence of the width
    // keeping in mind that both prev Height and prev width are less than current height and width
    public int solve(int[][] A) {
        //sort the Array basis height
        Arrays.sort(A, (env1, env2) -> Integer.compare(env1[0], env2[0]));
        //at minimum 1 envelope so init with 1
        int maxLen = 1;
        int[] prevLen = new int[A.length];
        prevLen[0] = 1;
        int res = 1;
        //LIS from 1st index
        for(int i=1;i < A.length;i++){
            maxLen = 1;
            int goBack = i;
            //go back to check if previous small env present
            while(goBack >= 0){
                //if both height and weidth are smaller than current
                if(A[goBack][0] < A[i][0]  && A[goBack][1] < A[i][1]){
                    //check considering that and current(+1) is it more than maxLen
                    if(prevLen[goBack] + 1 > maxLen){
                        //keep updating maxlen
                        maxLen = prevLen[goBack] + 1;
                    }
                }
                goBack--;
            }
            //put max len for curr i
            prevLen[i] = maxLen;
            //update ans for max, simultaniously
            res = Math.max(res, maxLen);
        }

        return res;
    }
}
