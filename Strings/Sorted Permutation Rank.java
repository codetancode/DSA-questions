public class Solution {
    public int findRank(String A) {
        //as no char are repeated, idea is to find count of small char in the up coming string and multiple the length!(len-1-i)!
        int len = A.length();
        int mod = (int)(1e6 + 3);

        //null case
        if(null == A) return 0;

        /*intitialize rank to 1; */
        int rank = 1;

        for(int i = 0; i <= len-1; i++){
            /* maintains count of characters less than index i */
             int count = 0;
             //find number of small chars from i=1 to n len
             for(int j = i+1; j < len; j++){
                 if(A.charAt(i) > A.charAt(j))
                    count++;
             }
             /*compute rank */
             //add small char count * factorial of length from i till len(len-1 - i)!
             rank = (rank + count * getFactorial(len-1-i, mod))%mod;
        }

        return rank%mod;
    }


    /*compute factorial*/
    public int getFactorial(int n, int mod){
        if (n==0) return 1 ;
        return (n* getFactorial(n-1, mod))%mod;
    }

}
