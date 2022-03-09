public class Solution {
    //O(n, 1) as sp is o/p only
    //using string builder appending right index for rotated string
    public String solve(String A, int B) {
        StringBuilder sb = new StringBuilder();
        int i=0;
        int n = A.length();
        //no change
        if(B%n == 0){
            return A;
        }
        else{
            //indexing
            B=B%n;
            i=n-B;
            sb.append(A.charAt(i%n));
            i=(i+1)%n;
            // using stringBuilder append right index
            while(i != n-B){
                sb.append(A.charAt(i%n));
                i=(i+1)%n;
            }
        }

        return sb.toString();
    }
}
