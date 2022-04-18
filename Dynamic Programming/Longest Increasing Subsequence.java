public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int lis(final int[] nums) {
        //O(nlogn),
        //idea is to keep finding/replacing increasing numbers as we go through the array,
        // using binary search to get just bigger index to replace or add
        int[] dp = new int[nums.length];
        int size = 0;

        for(int num: nums) {
            int left = 0, right = size, middle = 0;     // right = size
            // binary search
            //index of next greater number, using low
            while(left < right) {
                middle = (right + left)>>1;
                if(dp[middle] < num) left = middle + 1;
                else right = middle;
            }
            //as we have to increase left, put/replace new element in left,
            dp[left] = num;
            // increased size variable will give result
            if(left == size) size++;
        }

        return size;
    }
}
