public class Solution {
    //bf(n^3)
    //basic 3 loops solution, i<=j<=k
    public int solve(ArrayList<Integer> A, int B, int C, int D) {
        int maxVal = 0;

        for(int i=0;i < A.size();i++){
            for(int j=i;j < A.size();j++){
                for(int k=j;k < A.size();k++){
                    maxVal=Math.max(maxVal, B*A.get(i)+C*A.get(j)+D*A.get(k));
                }
            }
        }

        return maxVal;
    }
}
