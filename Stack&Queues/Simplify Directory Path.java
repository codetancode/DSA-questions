public class Solution {
    //O(n, n)
    //idea is to simply store each non (., ..) string skipping /, into stack, if .. pop from stack and
    //poping and keep appending it at start of string builder
    public String simplifyPath(String A) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int n = A.length();
        while (idx < n) {
            //getting / at start then adding words into sb
            if (A.charAt(idx) == '/') {
                idx++;
                while (idx < n && A.charAt(idx) != '/') {
                    sb.append(A.charAt(idx++));
                }
                String s = sb.toString();
                //resetting string builder setLength(0)
                sb.setLength(0);

                //reducing the stack for back directory ref(..), not doing anything for current dir reff .
                if (s.length() > 0) {
                    //if new is .., poping parent dir(if st!empty)
                    if (s.equals("..") && !stack.isEmpty()) {
                        stack.pop();
                    }//adding to stack only if its not .. or .
                    else if (!(s.equals("..") || s.equals("."))) {
                        System.out.println(s);
                        stack.push(s);
                    }
                }
            }
        }
        //inserting at start the directory and then that '/'
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        //if some directory in stack, else '/'
        return sb.length() > 0 ? sb.toString() : "/";

    }
}
