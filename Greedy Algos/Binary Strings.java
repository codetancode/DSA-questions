public class Solution {
    //O(n*n, n) BF
    //idea is taking binary string into int array of 1 and 0, go till n-B index
    // checking if their is a 0(to convert) ans++, and xor B char with 1(flip continous char),
    // check last n-B to n char, if still a 0 is found, not possible to convert into -1
    //else if no 0 true
    public int solve(String A, int B) {
        int res = 0;
        int n = A.length();
        int[] temmpA = new int[n];

        //fill tempA with 0/1
        for(int i=0;i < n;i++){
            temmpA[i] = A.charAt(i)-'0';
        }

        //go from 0 to n-B leaving last B char
        for(int i=0;i <= n-B;i++){
            //if a 0 found xor B char with 1 to make that 0 1, res++
            if(temmpA[i] == 0){
                res++;
                //from i to B char xor with 1
                for(int j=0;j < B;j++){
                    temmpA[i+j]^=1;
                }
            }
            //go to next index[doing xor for req possible subarray]
        }

        //if in last B char a 0 is still present cant do anything so return -1, else all true
        for(int i=n-B+1;i < n;i++){
            if(temmpA[i] == 0){
                //not possible
                return -1;
            }
        }
        return res;
    }
}
