public class Solution {
    //dp O(n, 1)- space optimized to 1
    //idea is to take max out of both top and bottom,
    //keep 2 prev val maintaining max in them, and take sum with max, either cur+prevprev, or just prev
    //max of (curr ele + (curr-2th ele), (curr-1)th ele)
    public int adjacent(ArrayList<ArrayList<Integer>> A) {
        //adding 0 for reference
        int maxSum = 0;
        int[] prevVal = new int[2];
        for(int i=0;i < A.get(0).size();i++){
            // storing max of top and bottom
            int maxTopBot = Math.max(A.get(0).get(i), A.get(1).get(i));
            if(i <= 1){
                //for 1st 2 values
                // keep 2 prev val maintaining max in them
                prevVal[i] = Math.max(maxTopBot, prevVal[0]);
            }else{
                //i > 1 so i-2 index exist
                int currPrePrevSum = maxTopBot + prevVal[0];
                int currPrevSum = prevVal[1];

                int maxSumTillNow = Math.max(currPrePrevSum, currPrevSum);
                maxSum += maxSumTillNow;
                //if currPrePrevSum greater, update prev as currPrePrevSum, and currPrePrevSum(prevVal[0]) as currPreSum
                if(currPrePrevSum > currPrevSum){
                    prevVal[0]=currPrevSum;
                    prevVal[1]=currPrePrevSum;
                }else{
                    //continue currPreSum in both as its greater
                    prevVal[0]=currPrevSum;
                    prevVal[1]=currPrevSum;
                }

            }
        }
        if(A.size() <= 2){
            //any depending on the input
            return Math.max(prevVal[0], prevVal[1]);
        }else{
            return maxSum;
        }
    }
}
