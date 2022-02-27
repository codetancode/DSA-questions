public class Solution {
    //O(n, n)
    //DP bottom up approach
    //we know 0 can do in 1 way, 1 can do in 1 way
    //after dealing with few test cases, found =>ways of n = ways of n-1 + (ways of n-2)*(n-1)
    public int solve(int A) {
        //linear dp array as pairing up
        int[] dp = new int[A+1];
        dp[0] = 1;
        dp[1] = 1;//one can party in 1 way alone
        int mod = 10003;
        for(int i=2;i <= A;i++){
            // so ways of n = ways of n-1 + (ways of n-2)*(n-1)
            //recursive relations for pair ups are,  ways for n = ways(n-1) + ways(n-2)*(n-1)
           dp[i] = (dp[i-1]%mod + dp[i-2]*(i-1)%mod)%mod;
        }
        //return ways for A ppl
        return dp[A];
    }
}
