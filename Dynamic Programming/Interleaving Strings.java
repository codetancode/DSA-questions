public class Solution {
    //dp bottom up best
    //idea is to store intermedeate result of A's index with B's index into a 2d dp array,
    //and as soon as we get those value return them in recursive calls
    static int[][] dp;
    //dp using meoization
    static boolean recFunTopDown(int pointA, int pointB, int pointC, String A, String B, String C){
        // base condition, if all reaches end
        if(pointC == C.length() && pointA == A.length() && pointB == B.length()){
            return true;
        }
        //if only c reaches end not A and B
        if(pointC == C.length()){
            return false;
        }
        //if dp array has values for given pointA, pointB, return from here directly
        if( dp[pointA][pointB] != -1 ){
            return (dp[pointA][pointB]==1)?true:false;
        }
        //if not then make 2 operations either extend A or B for common char in C
        boolean op1 = false;
        boolean op2 = false;
        if(pointA < A.length() && C.charAt(pointC) == A.charAt(pointA) ){
            op1 = recFunTopDown(pointA + 1, pointB, pointC + 1, A, B, C);
        }
        if(pointB < B.length() && C.charAt(pointC) == B.charAt(pointB) ){
            op2 = recFunTopDown(pointA , pointB + 1, pointC + 1, A, B, C);
        }
        //fill result of given pointA and pointB in DP array
        dp[pointA][pointB] = (op1|op2)?1:0;
        //return if possible by either of the operations
        return (op1|op2);
    }

    public int isInterleave(String A, String B, String C) {
        //depends on constraints, take extra 5 size
        dp = new int[105][105];
        // init with dp array for all with -1
        for(int i=0;i < 105;i++){
            for(int j=0;j < 105;j++){
                dp[i][j] = -1;
            }
        }
        return recFunTopDown(0, 0, 0, A, B, C)?1:0;
    }
}
