public class Solution {
    //O(2^n, n), as 2 function calls in return and recursive stack space
    public int solve(int[] A, int B) {
        return sol(0, B, 0, A);
    }
    //i for iteration on elements, size for size of elements considered, sum for sum, from array A
    static int sol(int i, int size, int sum, int[] A){
        if(sum > 1000){return 0;}
        // if size reaches it limit, return 1
        if(size == 0){return 1;}
        //if itterator reaches length
        if(i == A.length){return 0;}

        //selection + rejection
        //TS>=2^n
        return sol(i+1, size-1, sum+A[i], A) + sol(i+1, size, sum, A);

    }
}
