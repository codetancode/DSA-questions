public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY

    //idea is to go through all possible index pairO(n^2), check if valid O(n), then update max answer
    boolean validateString(String A, int from, int to){
        Stack<Character> st = new Stack<>();
        for(int i=from;i <= to;i++){
            char temp = A.charAt(i);

            if(!st.isEmpty()){
                //if st has opening and matching with new closing, pop opening
                if(temp == ')' && st.peek() == '(' || temp == ']' && st.peek() == '[' || temp == '}' && st.peek() == '{'){
                    st.pop();//pop corresponding closing
                }else{
                    //if not closing or not matching add them anyway
                    st.push(temp);
                }
            }else{
                //if 1st is closing return false(invalid)
                if(temp == ')' || temp == '}' || temp == ']'){
                    return false;
                }
                //add opening
                st.push(temp);
            }
        }
        //return if stack size ==0  boolean
        return st.size()==0;
    }

    public int LBSlength(final String A) {
        int res = 0;
        for(int i=0;i < A.length();i++){
            for(int j=i;j < A.length();j++){
                if(validateString(A, i, j)){
                    //update answer
                    res = Math.max(res, j-i+1);
                }
            }
        }

        return res;
    }
}
