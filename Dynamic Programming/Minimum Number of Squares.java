public class Solution {
    //O(nSqrt(n), n)
    //find minimum number of perfect sq requred to make sum to the given no.
    // 0-0                     0
    // 1-1^2                   1
    // 2-1^2+1^2               2
    // 3-1^2+1^2+1^2           3
    // 4-2^2                   1 possible {1^2+1^2+1^2+1^2(4), 2^2(1)} as we need minumum so 1
    //dp looking at 1 step back from n, and getting answer for that from stored array dp
    //dp[n] stores the ways for n. 1+ bcoz 1 step to reach n
    //using DP, dp[n] = ( 1 + min(dp[n-x*x])) for all x,such that x^2 <= n
    //base case dp[0] = 0, no perfect sq req. to make sum 0
    // idea is to keepfinding the numbers till sq of number <= required, storing results in DP array
    public int countMinSquares(int A) {
    ArrayList<Integer> dp = new ArrayList<Integer>(Collections.nCopies(A+1, 0));
    // base case for 0 we need 0 pf sq
    for(int i=1;i <= A;i++){
        //adding  1^2 i times  initially latter will find minimun
        dp.set(i, i);
        for(int x=1;x*x <= i;x++){
            //find minimum with max possible x*x value <=i
            dp.set( i, Math.min(dp.get(i), 1 + dp.get(i-x*x)) );
        }

    }
    //just return Ath index
    return dp.get(A);
    }
}
