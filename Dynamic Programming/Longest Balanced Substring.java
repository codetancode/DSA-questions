public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int LBSlength(final String A) {
        //O(n, n) solution using stack
        //idea is to store indexes of string and update max for valid string
        if(A.length() <= 1){
            return 0;
        }
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        //pushing -1 for empty stack, or imbalanced situation(more closing bracket)
        int ans = 0;
        for(int i=0;i < A.length();i++){
            char temp = A.charAt(i);

            // if opening push index into stack
            if(temp == '(' || temp == '{' || temp =='['){
                st.push(i);
            }else{
                //else if closing,
                //if stack stack peek is not -1, and
                // either of peek index is corrosponding opening for new closing char, pop opening index, get max
                if( (st.peek() != -1) &&(
                    (temp == '}' && A.charAt(st.peek()) == '{' ) ||
                    (temp == ']' && A.charAt(st.peek()) == '[' ) ||
                    (temp == ')' && A.charAt(st.peek()) == '(' )
                    ) ){
                    st.pop();
                    //as found valid index sequence wrt i and peek
                                // curr i - 1 index less than opening will give the difference(length of valid string)
                    ans = Math.max(ans, i-st.peek());
                }else{
                    //if closing bracket(not matching with peek)invalid string
                    st.push(i);
                }
            }
        }
        return ans;
    }
}
