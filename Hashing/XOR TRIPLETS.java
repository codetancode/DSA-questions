public class Solution {
    //O(n^4), 3 basing i, j, k loops, into it, 2 loops for combined n elements traversal
    //simple brute force
    public int solve(ArrayList<Integer> A) {
        int maxCount = 0;
        //sinlple 3 loops i to n-1
        for(int i=0;i < A.size();i++){
            // j=i+1 to n-1
            for(int j=i+1;j < A.size();j++){
                //k=j to n-1
                for(int k=j;k < A.size();k++){
                    int xorij = 0;
                    int xorjk = 0;
                    //as we need continous XOR
                    //getting xor value from i to j-1
                    for(int c=i;c < j;c++){
                        xorij^=A.get(c);
                    }
                    //getting xor value from j to k
                    for(int c=j;c <= k;c++){
                        xorjk^=A.get(c);
                    }
                    //check if xor is same or not
                    if(xorij == xorjk){
                        maxCount++;
                    }
                }
            }
        }
        return maxCount;

        }
}
