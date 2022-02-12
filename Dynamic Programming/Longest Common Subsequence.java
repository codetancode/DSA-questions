public class Solution {
    //O(n*m, n*m), best solution possible
    //using DP, making grid of char and check max to take or not to take
    //if same char put 1+digonal val, else max of top and left
    //         a   f   k   g
    //     0   0   0   0   0
    // k   0   0   0   1   1 k,k match so 1+diag 0,k, g dont so max of (top 0 and left 1)=1
    // g   0   0   0   1   2 g,k dont match so max of (top 1 and left 0) = 1, g, g match so (1+ diag1) = 2
    // y   0   0   0   1   2 y, k dont so max(top1, left0) =1, y,g dont match so max of (top2 and left 1 )= 2

    public int solve(String A, String B) {
        int[][] matrix = new int[A.length()+1][B.length()+1];
        int maxLen = 0;
        for(int i=0;i < A.length();i++){
            for(int j=0;j < B.length();j++){
                //Let 0th row and col is filled with 0, consider +1 index while adding values in matrix
                //if found same char do 1+ diagonal,
                // as considering curr char and diagonal has matching char count
                if(A.charAt(i) == B.charAt(j)){
                    matrix[i+1][j+1] = 1 + matrix[i][j];
                }else{
                    //if not matched, put the max of top and left cell
                    matrix[i+1][j+1] = Math.max(matrix[i][j+1], matrix[i+1][j]);
                }
                //max of current cell value
                maxLen = Math.max(maxLen, matrix[i+1][j+1]);
            }
        }
        return maxLen;
    }
}
