public class Solution {
    //using DP
    //O(n^2, n^2), - space can be optimized to n(2n, coz we need only current and previous rows)
    // O(digit*sum*10, digit*sum)
    //idea is to use known facts, i.e only 1 way for 1 digit to have sum <9, (sigin digit),
    // sum   0        1       2       3       4
    //digit0[0,       0,      0,      0,      0]
    //digit1[1ways, 1ways, 1ways, 1ways, 1ways]
    //digit2[0ways, 1ways, 2ways, 3ways, 4ways]
    //01 is not allowed so 10 1way
    //20, 11 2ways
    //30, 12, 21 3ways
    //40, 22, 13 ,31 4ways
    //ways to have 1 digit sum >9 =0, similarly sum <0 also 0
    public int solve(int A, int B) {
        int digit = A;
        int sum = B;
        int mod = 1000000007;//given in qstn
        //row digit, col sum, value as no. of ways for that digit to have that sum
        int[][] digitSumWays = new int[digit+1][sum+1];

        // if sum for that digit not possible
        if(sum > 9*digit){
            // coz max sum of n digit could be 9*n
            return 0;
        }

        //now culating Ways with the help of array for given digit Sum
        for(int dig = 1;dig <= digit;dig++){
            for(int s = 1;s <= sum;s++){
                // filling 1 way for single digit sum
                if(dig == 1 ){
                    digitSumWays[dig][s] = (s <= 9)?1:0;
                }
                else{
                    // trying and putting values 0-9 as k for 1 digit and calculating ways for (dig-1) and (s-k) rest,
                    // and adding ways for other digit to make sum(dig-1) and (s-k)
                    for(int k=0;k <= 9;k++){
                        // if sum is greater that k
                        if(s > k){
                            //putting k and checking how many ways for rest digits so(digit-1)(prev row only) and (sum-k), adding digitSumWays[dig-1][s-k];
                            digitSumWays[dig][s] = (digitSumWays[dig][s]%mod + digitSumWays[dig-1][s-k]%mod)%mod;
                        }
                    }
                }
            }
        }
        //just return for given digit and given sum
        return digitSumWays[digit][sum]%mod;
    }
}
