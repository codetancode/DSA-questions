public class Solution {
    //brute force recursive
    //dp top down recursive solution
    //idea is to have 3 pointers to 3 strings, and for same char in both A and B, try incrementing in both and check it it satisfies
    static boolean recFunTopDown(int pointA, int pointB, int pointC, String A, String B, String C){
        // base condition, if all reaches end
        if(pointC == C.length() && pointA == A.length() && pointB == B.length()){
            return true;
        }
        //if c reaches end and not A and B
        if(pointC == C.length()){
            return false;
        }

        //2 operation for either incrementing A, or B for same char in C
        boolean op1 = false;
        boolean op2 = false;
        //incrementing A
        //check valid point A , then same char at C
        if(pointA < A.length() && C.charAt(pointC) == A.charAt(pointA) ){
            op1 = recFunTopDown(pointA + 1, pointB, pointC + 1, A, B, C);
        }
        //incrementing B
        //check valid point B , then same char at C
        if(pointB < B.length() && C.charAt(pointC) == B.charAt(pointB) ){
            op2 = recFunTopDown(pointA , pointB + 1, pointC + 1, A, B, C);
        }

        //return OR of both operations
        return op1|op2;

    }
    public int isInterleave(String A, String B, String C) {
        return recFunTopDown(0, 0, 0, A, B, C)?1:0;
    }
}
