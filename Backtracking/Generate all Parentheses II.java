public class Solution {
    //O(2^n, n) as possible 2 function call, and recursive stack space
    //idea is to have a blank temp string, filling it and storing it into res(array of string)
    static void getPar(ArrayList<String> res, String temp, int len, int open, int close){
        // if temp string len reached 2*len(A), add to res
        if(temp.length() == 2*len){
            res.add(temp);
        }
        // start with open till len, check is open count is less than len
        if(open < len){
            //add open to temp, and increase open count
            getPar(res, temp + "(", len, open + 1, close);
        }
        //so for every open we need a close, so comparing it with, close count to call for close bracket
        if( close < open ){
            getPar(res, temp + ")", len, open, close + 1);
        }

    }
    public ArrayList<String> generateParenthesis(int A) {
        String temp = "";
        ArrayList<String> res = new ArrayList<String>();
        //as start empty string temp, and both open and close breckets are 0
        getPar(res, temp, A, 0, 0);
        return res;
    }
}
