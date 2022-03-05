public class Solution {
    //O(n^2, n^2), traversal on 2d dp array
    //iterative approach, using 2d array
    //dp using bottom up approach,
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        //as only weights and index are changeing in recursive call,
        ArrayList<ArrayList<Integer>> dp = new ArrayList<ArrayList<Integer>>();
        // index rows, and weights col
        for(int i=0;i <= A.size() ;i++){
            dp.add(new ArrayList<>(C + 1));
            for(int j=0;j <= C ;j++){
                //known as for i=0, j=0, i.e n-0 and weitht =0, no profit
                dp.get(i).add(0);
            }
        }
        //as their are 2 variables in recursive call, n and weights C, consider them as i, j respectively
        for(int i=1;i <= A.size() ;i++){
            for(int j=1;j <= C ;j++){
                //if current weight is(B.get(i-1)) <= possible weight(capacity) j
                if(B.get(i-1) <= j){
                    //max of either non selecting(dp.get(i-1).get(j)), or selecting weight(dp.get(i-1).get(j - B.get(i-1)))
                    dp.get(i).set(j, Math.max(dp.get(i-1).get(j), A.get(i-1) + dp.get(i-1).get(j - B.get(i-1)) ) );
                }else{
                    //else weight of current item is higher than the given capacity j(C), so not selecting
                    dp.get(i).set(j, dp.get(i-1).get(j));
                }
            }
        }

        return dp.get(A.size()).get(C);
    }
}
