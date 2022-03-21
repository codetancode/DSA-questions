class Solution {
    public boolean canPartition(int[] nums) {
        //if sum of array is even we can check if 2 subsets sum == or not, but if odd, cannot find 2 == sum
        int sumOfArray = 0;
        int n = nums.length;
        for(int i=0;i < n;i++){
            sumOfArray += nums[i];
        }

        if(sumOfArray%2 != 0){
            return false;
        }else{
            // check if half exist or not
            int halfSum = sumOfArray/2;
            boolean[][] dp = new boolean[n+1][halfSum+1];
            // init dp array
            for(int i=0;i < n+1;i++){
                for(int j=0;j < halfSum+1;j++){
                    //if no elements then 0 possibility of any sum except 0
                    if(i==0){
                        dp[i][j] = false;
                    }
                    //as we know for 0 elements and 0 sum 1 possibility empty set{}
                    if(j==0){
                        dp[i][j] = true;
                    }
                }
            }


            for(int i=1;i < n+1;i++){
                for(int j=1;j < halfSum+1;j++){
                    //can take the emelents, i.e element is less than sum(j)
                    if(nums[i-1] <= j){
                        //here i is element index, and j is corrosponding sum
                        // new dp i, j = not selecting(i-1, j) or selecting (i-1)(j-nums[i-1])
                        dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }

        return dp[n][halfSum];

        }

    }
}