public class Solution {
    //O(n, 1)
    //idea is to count Az and when we get G, add Az count into result, as many times we get G
    public int solve(String A) {
        int i=0;
        int acount = 0;
        int res = 0;

        for(i=0;i < A.length();i++){
            //counting As
            if(A.charAt(i) == 'A'){
                acount += 1;
            }
            else if (A.charAt(i) == 'G'){
                //if G found adding Az count in result for this G
                res += acount;
            }
        }

        return res;
    }
}
