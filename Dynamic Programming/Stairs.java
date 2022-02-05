public class Solution {
    //irrtative O(n, 1)
    public int climbStairs(int A) {
        //point to note here is at stair 0 ways is 1
        //point to note here is at stair 1 ways is 1
        // now using Dp(knowledge of ways for 0 staris and 1 stair calculate ways for A)
        int start0 = 1;
        int start1 = 1;
        int ans=1;
        //now going for stairs 2 till A, temp in the end will have answer for A
        for(int i=2;i <= A;i++){
            ans = start0 + start1;
            //moving forward updating values
            start0 = start1;
            start1 = ans;
        }

        return ans;
    }
}
