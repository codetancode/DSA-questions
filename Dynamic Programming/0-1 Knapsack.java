public class Solution {
    //O(2^n, n), recursive so call stack space, will give TLE
    //recursive without memoization so will give TLE
    int knapSack(ArrayList<Integer> values, ArrayList<Integer> weights, int w, int index){
        // as index can go to 0, so checking if this fun call is for index -1, then return 0
        if(index == -1 || values.size() == 0){
            return 0;
        }
        if(weights.get(index) <= w){
            //when we can take that weight
            // choosing this, weight will reduce and index also will reduce
            int choice1 = values.get(index) + knapSack(values, weights, w - weights.get(index), index - 1);
            // and not choosing this, weight wont reduce but index will
            int choice2 = knapSack(values, weights, w , index - 1);
            return Math.max(choice1, choice2);
        }else{
            //1 items is only more that the capacity so return
            return knapSack(values, weights, w, index - 1);
        }
    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        return knapSack(A, B, C, A.size()-1);
    }
}
