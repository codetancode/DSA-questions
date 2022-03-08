public class Solution {
    //O(n, 1)
    //idea is to keep tow pointer at the ends and count mismatch char
    //for even len, if mismatch count is not 1 false
    //for odd len, if mismatch count is more than 2 false
    public String solve(String A) {
        int n = A.length();
        int i=0;
        int j=n-1;
        int count =0;
        while(i < j){
            if(A.charAt(i) != A.charAt(j)){
                    count++;
                }
                i++;
                j--;
        }
        //put all no condition by default Yes

        //for even length we need only 1 mismatch
        if(n%2 == 0 && count != 1){
           return "NO";
        }
        //for odd length we need only 2 mismatch(mid, and anyother)
        if(n%2 == 1 && count > 2){
            return "NO";
        }
        return "YES";
    }

}
