public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int LBSlength(final String A) {
        // O(n, n)traversing and dp array
        // idea is to take up dp array, maintaing prev to check prev opening of same kind as that of current,
        // and update ans in curr +1 index (so dp od size len+1)
        int[] dp = new int[A.length()+1];
        int maxCount = 0;
        for(int i=1;i < A.length();i++){
            //checking prev indexs for corresponding opening using (curr - dp of curr -1)
            int prevCheck = i - dp[i] - 1;

            // if prevCheck>=0, coz refrencing in dp array
            //if j has corresponding opening for current closing of anykind
            if( (prevCheck >= 0) &&
            ( ( A.charAt(prevCheck) == '('  && A.charAt(i) == ')')
            || ( A.charAt(prevCheck) == '['  && A.charAt(i) == ']')
            || ( A.charAt(prevCheck) == '{'  && A.charAt(i) == '}')
             ) ){
                //update in curr = 1 index +2 as we found atleast opening and closing of 2 len + Dp of earlier
                //so dp of curr + 1 = dp of curr + dp of prev + 2(new found)
                dp[i+1] = dp[i] + dp[prevCheck] + 2;
                //update max len
                maxCount = Math.max(maxCount, dp[i+1]);
            }
        }
        return maxCount;
    }
}
