public class Solution {
     static void showAL(ArrayList<Integer> al) {
    	System.out.print("{ ");
    	for(int i=0;i < al.size();i++) {
    		System.out.print(al.get(i)+" ");
    	}
    	System.out.println(" }");
    }
    //O(n^2, n)0-n knapsack
    // dp solution- storing max values of i cuts into array costForiCuts
    public int solve(ArrayList<Integer> A) {
        //as we need max after n pieces taking i+ array size
        ArrayList<Integer> costForiCuts = new ArrayList<Integer>(Collections.nCopies(A.size()+1, 0));

        //base condition is for 0 len cost =0, so costForiCuts[0] = 0, and starting with i=1 to =size of A
        for(int i=1;i < A.size()+1;i++){
            int maxCost = Integer.MIN_VALUE;
            //for getting maximun values considering 0 to i-1 pieces using j loop
            //j=0 to i-1
            for(int j=0;j < i;j++){
                //
                maxCost = Math.max(maxCost, A.get(j) + costForiCuts.get(i-j-1));
            }
            costForiCuts.set(i, maxCost);
        }
        // showAL(costForiCuts);
        return costForiCuts.get(A.size());
    }
}
