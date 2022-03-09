public class Solution {
    //possible ways for right and dow ways asre
    //Total permutations = (m+n)! / (m! * n!)
    public int uniquePaths(int A, int B) {
        int n = A;
        int m = B;

        if(m == 1 || n == 1)
            return 1;

        // as indexes so -1
        m--;
        n--;
        // Swap, so that m is the bigger number
        if(m < n) {
            m = m + n;
            n = m - n;
            m = m - n;
        }

        long res = 1;
        int j = 1;
        // at start for calculation((m+n)! / (m! * n!)),
        // i is m+1 (numerator) and j is 1(denominator)
    //Total permutations = (m+n)! / (m! * n!)
        for(int i = m+1; i <= m+n; i++, j++){       // Instead of taking factorial, keep on multiply & divide
            res *= i;
            res /= j;
        }

        return (int)res;
    }
}
