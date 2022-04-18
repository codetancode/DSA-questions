public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    static int INF = 10000000;
    static int[][] dp = new int[1005][1005];
    public int solve(final int[] A, final int[] B, final int[] C) {
        ArrayList < Pair > dish = new ArrayList < Pair > ();
        int n = C.length;

        //fill item filling capacity(itemCap) and its cost as Pairs
        for (int i = 0; i < n; i++)
            dish.add(new Pair(B[i], C[i]));

        //get maximum eating capacity, of friends
        int m = -1;
        for (int i = 0; i < A.length; i++)
            m = Math.max(m, A[i]);

        //for DP matrix of row(m) as Max eating capacity of friends, and col(n) as Pairs(item filling capacity, item cost)
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                //1st row, where we have 0 eating capacity, from friends
                if (i == 0)
                //put 1st row as 0
                    dp[i][j] = 0;
                else if (j == 0)
                //j==0 =>1st col, where we have 0 Pair value or 0 item value, then cost is Infinity, for all friends eating capacity (row value)
                    dp[i][j] = INF;
                else {
                    //now if eating capacity of friend(i) >= item capacity of (j-1) pair
                    if (i >= dish.get(j - 1).itemCap) {
                        //answer(min cost) for that eating capacity(i), and given 0 till that (j-1) pairs of items, will be
                            //not chosing->(dp[i][j-1])    choosing->  eating cap(i) - itemCap, + cost of this chosen item
                        dp[i][j] = Math.min(dp[i][j - 1], dp[i - dish.get(j - 1).itemCap][j] + dish.get(j - 1).itemCost);
                    } else{
                        //else any way cant choose as friends eating capacity is < item filling capacity
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }
        int ans = 0;
        //now summing up for all n different friends A, as we have their min Cost calculated at n index
        for (int i = 0; i < A.length; i++) {
            ans += dp[A[i]][n];
        }

        return ans;
    }
}
class Pair {
    int itemCap;
    int itemCost;
    public Pair(int a, int b) {
        this.itemCap = a;
        this.itemCost = b;
    }
}
