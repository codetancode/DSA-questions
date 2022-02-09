public class Solution {
    // O(n, n) DP solution
    //idea is to store dp values in next index and keeping a variable to check prev opening
    public int longestValidParentheses(String A) {
        //as updating in current + 1 index so len+1 size
        ArrayList<Integer> dp = new ArrayList<Integer>(Collections.nCopies(A.length()+1,0));
        int maxLen = 0;
        for(int i=0;i < A.length();i++){
            //prev check is curr - dp of curr -1
            int prevCheckIndex = i-dp.get(i) - 1;
            //if prevCheckIndex is not -ve, and prev has opening and curr has closing
            //update in curr index + 1 about new found ans 2+ dp of curr
            if(prevCheckIndex >= 0 && A.charAt(prevCheckIndex) == '(' && A.charAt(i) == ')'){
                int newLen = 2 + dp.get(i) + dp.get(prevCheckIndex);
                dp.set(i+1, newLen);
                maxLen=Math.max(maxLen, newLen);
            }
        }

        return maxLen;
    }
}
