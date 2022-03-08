public class Solution {
    //DP solution memoized
    //as i and j are variables in recursive calls, 2d array of this combinations, as per given constraints
    static int[][] dp = new int[502][502];
    //idea is to keep 2 variable i and j form start and last, keep checking and making partation at k
    //storing min no. of partation and return it
    int checkEveryInterIndex(int i, int j, String A){
        //if reached end, i, j crossed
        if(i > j){
            return 0;
        }
        //even if the string is panindrime it self no need of partation so return 0 from here itself
        if(isPalindrom(i, j, A)){
            return 0;
        }
        // if dp already has ans calculated for given i, j pair, return from here
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int minPart = Integer.MAX_VALUE;
        //making partation from i to k, and k+1 to j
        //k should go till j-1 index as we are calling (k+1, j)
        for(int k=i;k <= j-1;k++){
            //now making this partation(so +1) from i to k nad k+1 to j,
            int tempAns = checkEveryInterIndex(i, k, A) + checkEveryInterIndex(k + 1, j, A) + 1;
            //keep storing min
            minPart = Math.min(minPart, tempAns);
        }
        //store answer into dp for this i, j combinations
        dp[i][j] = minPart;

        return minPart;
    }
    //check palindrome b/w i to j
    boolean isPalindrom(int from, int to, String A){
        while(from <= to){
            //if a char dont mathc return false
            if(A.charAt(from) != A.charAt(to)){
                return false;
            }
            from++;
            to--;
        }
        return true;
    }
    public int minCut(String A) {
        //init dp for i, j parai answers
        for(int i=0;i < 502;i++){
            for(int j=0;j < 502;j++){
                dp[i][j] = -1;
            }
        }

        //calling form i=0, j-n-1
        return checkEveryInterIndex(0, A.length()-1, A);
    }
}
