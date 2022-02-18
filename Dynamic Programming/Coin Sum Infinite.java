public class Solution {
    //O(n*B, B) DP
    //idea is to keep filling ways for the sum with every coin, using previous ways of sum, in a dpwaysSum array
    static void showAL(ArrayList<Integer> al) {
    	System.out.print("{ ");
    	for(int i=0;i < al.size();i++) {
    		System.out.print(al.get(i)+" ");
    	}
    	System.out.println(" }");
    }
    public int coinchange2(ArrayList<Integer> A, int B) {
        // ArrayList<Integer> dpWays = new ArrayList<Integer>(Collections.nCopies(B+1, 0));
        int mod = 1000007;
        // as having 0 sum in 1 way
        int[] dpWays = new int[B+1];
        //sum 0 in 1 way so initilize it
        dpWays[0] = 1;

        // for every coin update ways of getting all sums in the array
        for(int i = 0; i < A.size(); i++) {
            // if coin value <= sum
            for(int j = A.get(i); j <= B; j++) {
                                            // ways for (sum - current coin value
                dpWays[j] = ((dpWays[j] % mod) + (dpWays[j - A.get(i)] % mod)) % mod;
            }
        }

        return dpWays[B] % mod;
    }
}
