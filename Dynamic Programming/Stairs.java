public class Solution {
    //recursive dp structure
    //O(2^n, n)
    //1 function calling 2 function similar to fibonacii
    //recur. stach space of n
    int dprecursive(int stair){
        //point to note here is when stairs == 0, then also return 1 cox WAYS
        //in 1 way stairs ==0
        if(stair == 0){return 1;}
        if(stair == 1){return 1;}
        //possible ways for stair-1 + possible ways for stairs-2
        return dprecursive(stair-1)+dprecursive(stair-2);

    }
    public int climbStairs(int A) {
        return dprecursive(A);
    }
}
