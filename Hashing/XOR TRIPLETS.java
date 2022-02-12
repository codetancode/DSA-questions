public class Solution {
    //O(n, n),
   //idea is to find xor value 0 of a sub array and keep maintaining index difference for j
   //we find 0 at k index, (k1-i1),(k2-i2)..
   //nk-i1-i2..
    public int solve(ArrayList<Integer> A) {
        // TriNode root = new TriNode();
        // xorZeroFreq = 1;
        // xorZeroIndex = 0;

        HashMap<Integer, ArrayList<Integer>> xorvalTofrqIndexSum = new HashMap<>();
        int mod = 1000000007;
        int maxSub = 0;
        int contXor = 0;
        //adding 0 and its freq as 1 and sum of index as 0
        xorvalTofrqIndexSum.put(0, new ArrayList<Integer>(2));
        xorvalTofrqIndexSum.get(0).add(1);
        xorvalTofrqIndexSum.get(0).add(0);
        for(int i=0;i < A.size();i++){
            contXor^=A.get(i);

            if(xorvalTofrqIndexSum.containsKey(contXor)){
                int xorValFreq = xorvalTofrqIndexSum.get(contXor).get(0);
                int xorValIndexSum = xorvalTofrqIndexSum.get(contXor).get(1);
                //adding Freq of xor value*current index - (xorValueIndexSum)
                maxSub = (maxSub%mod + (xorValFreq*(i))%mod-(xorValIndexSum)%mod )%mod;

                //also update map for this contXorval
                xorvalTofrqIndexSum.get(contXor).set(0, xorValFreq + 1);
                //updating index sum as prev index + currIndex + 1(for 0 based indexing)
                xorvalTofrqIndexSum.get(contXor).set(1, xorValIndexSum + i + 1);

            }else{
                xorvalTofrqIndexSum.put(contXor, new ArrayList<Integer>(2));
                //adding 0 and its freq as 1 and sum of index as currIndex +1 for 0 based indexing
                xorvalTofrqIndexSum.get(contXor).add(1);
                xorvalTofrqIndexSum.get(contXor).add(i+1);
            }

        }
        return maxSub%mod;

        }
}
