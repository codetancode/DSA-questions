public class Solution {
    //~O(n^2, n^2), almost as recursive memoized
    //dp using memoization
    int knapSack(ArrayList<Integer> values, ArrayList<Integer> weights, int w, int index, ArrayList<ArrayList<Integer>> dp){
        // as index can go to 0, so checking if this fun call is for index -1, then return 0
        if(index == 0 || values.size() == 0){
            return 0;
        }

        if(weights.get(index-1) <= w){
            //when we can take that weight
            // choosing this, weight will reduce and index also will reduce
            if(dp.get(index).get(w) != -1){
                return dp.get(index).get(w);
            }

            int choice1 = values.get(index-1) + knapSack(values, weights, w - weights.get(index-1), index - 1, dp);
            // and not choosing this, weight wont reduce but index will
            int choice2 = knapSack(values, weights, w , index - 1, dp);

            dp.get(index).set( w, Math.max(choice1, choice2));

            return Math.max(choice1, choice2);
        }else{
            //1 items is only more that the capacity so return
            dp.get(index).set( w, knapSack(values, weights, w, index - 1, dp));
            return dp.get(index).get(w);
        }
    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        //as only weights and index are changeing in recursive call,
        ArrayList<ArrayList<Integer>> dp = new ArrayList<ArrayList<Integer>>();
        // index rows, and weights col
        for(int i=0;i <= A.size() ;i++){
            dp.add(new ArrayList<>(C + 1));
            for(int j=0;j <= C ;j++){
                dp.get(i).add(-1);
            }
        }

        return knapSack(A, B, C, A.size(), dp);
    }
}
