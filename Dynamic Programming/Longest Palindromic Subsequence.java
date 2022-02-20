public class Solution {
    //O(n*n, n*n)
    //idea is simply find Longest common subsequence length of current string and its reverse, that will give longest palindromic subsequence
    int LCS(String A, String B){
        int n=A.length();
        int m=B.length();
        int[][] matrix = new int[n+1][m+1];
        for(int i=0;i < n;i++){
            for(int j=0;j < m;j++){
                if(A.charAt(i) == B.charAt(j)){
                    //if same char then diagonal + 1
                    matrix[i+1][j+1] = 1 + matrix[i][j];
                }else{
                    //else max of top and left
                    matrix[i+1][j+1] = Math.max(matrix[i][j+1], matrix[i+1][j]);
                }
            }
        }
        return matrix[n][m];
    }
    public int solve(String A) {
        String A1 = A;
        //make a reverse of A, then find LCS of both
        StringBuilder sb = new StringBuilder(A);
        sb.reverse();
        return LCS(A1, sb.toString());
    }
}
