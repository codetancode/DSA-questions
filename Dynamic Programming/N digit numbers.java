public class Solution {
    //using DP
    //O(n^2, n), - space optimized to 2n(coz we need only current and previous rows)
    // O(digit*sum*10, digit*2)
    //storing only 2 arrays current and prev for calculations
    public int solve(int A, int B) {
        int digit = A;
        int sum = B;
        int mod = 1000000007;//given in qstn
        //arrays is only having ways, for index-sum
        ArrayList<Integer> currDigitWays = new ArrayList<>(Collections.nCopies(sum+1, 0));
        ArrayList<Integer> prevDigitWays = new ArrayList<>(Collections.nCopies(sum+1, 0));

        // if sum for that digit not possible
        if(sum > 9*digit){
            // coz max sum of n digit could be 9*n
            return 0;
        }

        //now calculating Ways with the help of array for given digit Sum
        for(int dig = 1;dig <= digit;dig++){
            for(int s = 1;s <= sum;s++){
                //only 1 digit ways can only be 1 for s sum, so
                if(dig == 1){
                    //fill currDigitWays wiht 1
                    currDigitWays.set(s, (s <= 9)?1:0);
                }else{
                    //as digit are more than 1, trying k(0-9) and suing previous row
                    for(int k=0;k <= 9;k++){
                        if(s > k){
                            // if s is greater than k(trying values) adding up values so curr + other possible ways from pre digit
                            currDigitWays.set(s, currDigitWays.get(s)%mod + prevDigitWays.get(s-k)%mod);
                        }
                    }
                }
            }
            //swapping prev=curr;
            prevDigitWays = currDigitWays;
            //new curr(all 0s) for next digit
            currDigitWays = new ArrayList<>(Collections.nCopies(sum+1, 0));
        }

        // as prev will have actuall values
        return prevDigitWays.get(sum)%mod;
    }
}
