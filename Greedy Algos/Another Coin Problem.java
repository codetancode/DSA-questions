public class Solution {
    //O(1, 1) constant 15 exponent array traversal, and only 15 array space
    //idea is to store all possible 5 exponents into long array of size 15(qstn contraints) and
    // loop from last till A==0, reducing A values
    //global 5 power array
    static long[] fivePow;
    static void fillFive(){
        fivePow = new long[16];
        fivePow[0] = 1;
        long prev = 5;
        //5 power till 15 as long
        for(int i = 1;i <= 15;i++){
            fivePow[i] = prev;
            prev = 5*prev;
        }
    }

    public int solve(int A) {
        int resCoin = 0;
        fillFive();

        int i=15;
        //going from 15 to power to 0
        while(i >= 0){
            //for higher values coins division will always be 0 so 0 will get added
            //getting coins req. for that exponent value
            int coin = (int)((long)A/fivePow[i]);
            // adding coins in resultant
            resCoin += coin;

            //reducing coin value from given A
            A -= (fivePow[i]*coin);
            i--;
        }

        // returning result
        return resCoin;
    }
}
