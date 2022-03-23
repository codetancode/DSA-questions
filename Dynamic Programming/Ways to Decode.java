public class Solution {
    public int numDecodings(String A) {
        //taking a dp len, init 0 as 1,
        int n = A.length();
        int mod = 1000000007;
        int[] dp = new int[n+1];
        dp[0] = 1;
        //if 1st char is not 0, so put 1 way at 1 index
        if(A.charAt(0) != '0'){
            dp[1] = 1;
        }

        for(int i=2;i <= n;i++){
            //if 2nd cahr is b/w 1-9, add 1 way(previous)
            if(A.charAt(i-1) >= '1' && A.charAt(i-1) <= '9'){
                dp[i] += dp[i-1]%mod;
            }

            //if prev char is 1 , add previous again
            if(A.charAt(i-2) == '1'){
                dp[i] += dp[i-2]%mod;

            // else if prev char is <=2, and curr char is <= 6, add previous
            }else if(A.charAt(i-2) == '2' && A.charAt(i-1) <= '6'){
                //as bot curr and prev are less than =26, add previous
                dp[i] += dp[i-2]%mod;
            }
        }

        return dp[n]%mod;
    }
}
