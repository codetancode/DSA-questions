public class Solution {
    //O(n^3, 1) bf solution, use dp to store interem values and reduce time
    //n^2 for every sequence, O(n) for validating every sequence, so O(n^3)
    boolean validateString(String s, int frm, int to){
        Stack<Character> st = new Stack<>();
        // if st has some val, and new val is closing, pop
        // if st has no value and new val is closing return false
        //only add opening in stack, return if size==0 in the end
        for(int i=frm;i <= to;i++){
            char temp = s.charAt(i);
            if(!st.isEmpty()){
                if(temp == ')' && st.peek() == '('){
                    st.pop();
                }
            }else{
                //ist char is closing then to return false
                //if closing is more
                if(temp == ')'){
                    return false;
                }
            }
            //add only opening
            if(temp == '('){
                st.push(temp);
            }

        }
        // if any opening remained
        return st.size()==0;
    }
    public int longestValidParentheses(String A) {
        int validCount = 0;
        for(int i=0;i < A.length()-1;i++){
            for(int j=i+1;j < A.length();j++){
                //for all i to j sequence if valid. update max
                if(validateString(A, i, j)){
                    validCount=Math.max(validCount, j-i+1);
                }
            }
        }
        // return sequence length
        return validCount;
    }
}
