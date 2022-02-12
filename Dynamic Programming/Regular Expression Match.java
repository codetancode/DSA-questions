public class Solution {
    //O(n*m, n*m) best Dp Solution
    //idea is keep boolean matrix for both text(A) and pattern(B), for the substring,
    //if sam char or ? is patter, put diagonal, if * in pattern pu OR of top and left,
    //for entire string result will be at diagonal end

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int isMatch(final String A, final String B) {
        int textLen = A.length();
        int patterLen = B.length();
        boolean[][] match = new boolean[textLen + 1][patterLen + 1];
        // text(A) as ROW, and Patter(B) as COL, 0th ro, col considering empty strings
        //if both are empty return true
        match[0][0] = true;
        //if text is '' and pattern is *, it should match so putting true, else all already false so break
        //filling if A==0, then patter true/false will be
        for(int i=0;i < patterLen;i++){
            if(B.charAt(i) == '*'){
                match[0][i+1] = true;
            }else{
                break;
            }
        }
        //no need to put false for 1st col as already false

        for(int i=0;i < textLen;i++){
            for(int j=0;j < patterLen;j++){
                //if char frm A match or pattern from B is ?(dont care), retain prev found result (diagonal)
                if(A.charAt(i) == B.charAt(j) || B.charAt(j) == '?'){
                    //curr = diagonal value
                    match[i+1][j+1] = match[i][j];
                }else if(B.charAt(j) == '*' ){
                    //if pattern is *, A could be anything so fill curr with OR,
                                    // Left result OR  Top result
                    match[i+1][j+1] = match[i][j+1] | match[i+1][j];
                }

            }
        }
        //result of entire text(A) with entire patter(B) will be at last
        return match[textLen][patterLen]?1:0;
    }
}
