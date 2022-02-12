public class Solution {
    //O(n*m, n*m) best DP solution
    //we need to create 2d cost matrix for 2 different strings
    //base condition is if len(a) == 0, put cost of insertion*len(B), if len(b) == 0, put cost of deletion*len(A),
    //for rest of cases we need to find out the min cost for every charin both string for
    // Insertion , deletion, or Replaceing cost, incase both char are unequal
    //else continue with diagonal with no cost
    //B->(side(col))
    //A|(a down(row)
    // v  [if len(B) == 0,deletion cost*len of A=>(1*length(A)]
    //    0    a   b   f
    //0   0    1   2   3  [if a is 0, addition cost*len of B=>(1*length(B)]
    //b   1    2   1M  2     [b,a dont match so pick min of (add, del, replace cost) from top , left and diagonal respectively]
    //d   2    2   2   2   so ultimatly 2 is the cost to make String A(bd) as String B(abf)i.e (add a with 1 cost, replace (d->f) in 1 cost)
    public int minDistance(String A, String B) {
        //ROW are A, COL are B
        // as cost of all operation is 1, for 0 adding extra row and col
        int[][] costMatrix = new int[A.length()+1][B.length()+1];
        // BASE condition
        //at 0, 0 default 0
        //if a.len==0, fill COl to insertion cost*lenof(b)
        for(int i=0;i < A.length();i++){
            costMatrix[i+1][0] = 1*(i+1);
        }
        //if b.len==0, fill ROW to deletion cost*lenof(a)
        for(int i=0;i < B.length();i++){
            costMatrix[0][i+1] = 1*(i+1);
        }
        //now going through A char rows and B char cols
        for(int i=0;i < A.length();i++){
            for(int j=0;j < B.length();j++){
                //filing matrix at i+1 and j+1, getting char from string at i, j
                //if dont mathc we can min(add, del, replace)
                if(A.charAt(i) != B.charAt(j)){
                    //put min of all cost Add, Del(top, left) , replace(diagonal),
                    //min of top and left(+1 for added cost of add or del)
                    int minOfAddDel = Math.min(costMatrix[i+1][j]+1, costMatrix[i][j+1]+1);
                                        // put min of topLeft and diagonal
                    costMatrix[i+1][j+1] = Math.min(minOfAddDel, costMatrix[i][j] + 1);
                }else{
                    // if char are same then just put diagonal(continue with the diagonal), with no cost
                    costMatrix[i+1][j+1] = costMatrix[i][j];
                }
            }
        }
        //return diagonal of matrix as that would have best cost,
        // by the end of both string A and B
        return costMatrix[A.length()][B.length()];
    }
}
