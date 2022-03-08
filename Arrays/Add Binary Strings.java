public class Solution {
    //O(n, 1) traversal of max straing, String res is output so not considering space
    public String addBinary(String A, String B) {
        String res = "";
        //goinf from last index to 1st
        int i = A.length()-1;
        int j = B.length()-1;
        //keeping sum for carry check
        int sum=0;
        // if reached 0 index, or has carry/sum==1
        while(i >= 0 || j >= 0 || sum == 1 ){
            //efficient way of keeping sum if present, else 0
            sum += (i >= 0)?A.charAt(i)-'0':0;
            sum += (j >= 0)?B.charAt(j)-'0':0;

            //storing in res String %2, then /2
            res = (char)(sum%2 +'0') + res;
            sum = sum/2;
            i--;
            j--;
        }

        return res;
    }
}
