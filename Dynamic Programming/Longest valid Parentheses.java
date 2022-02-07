public class Solution {
    //idea is to use stack for keeping string index(only opening), check if valid with top and new char and update answer max
    public int longestValidParentheses(String A) {
        Stack<Integer> st = new Stack<>();
        //as doing peek in loop for taking max
        st.push(-1);
        int res=0;
        for(int i=0;i < A.length();i++){
            char temp = A.charAt(i);
            // if opening add index
            if(temp == '('){
                st.push(i);
            }else{
                //check if closing matching with last opening
                //as doing peek for max in loop so keeping -1 as top refreence(for imbalanced)
                // (more closing in test cases)
                if(st.peek() != -1 && (temp == ')' && A.charAt(st.peek()) == '(')){
                    st.pop();
                    //pop opening index, now get length of valid string from
                    //curr i - (1-opening index) this will give length
                    res = Math.max(res, i-st.peek());
                }else{
                    //if imbalanced keep adding closing index
                    st.push(i);
                }
            }
        }
        return res;
    }
}
