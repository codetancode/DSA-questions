public class Solution {
    //O(n, 1) as n is sum of length of all strings, given
    //idea is to check min len string in given array, and check charAt index only till that index
    public String longestCommonPrefix(ArrayList < String > A) {
        //test case cover
        if (A.size() == 0)
            return "";
        String str;
        String res = "";
        int min = Integer.MAX_VALUE;
        // get min length string 1st from given array
        for (int i = 0; i < A.size(); i++) {
            min = Math.min(min, A.get(i).length());
        }
        //now only traverse min length, and
        for (int i = 0; i < min; i++) {
            //consider 1st string char, and check if all other string has same char or not in J loop
            char c = A.get(0).charAt(i);
            // check if c character is same in every string or not (starting from index 1 string)
            for (int j = 1; j < A.size(); j++) {
                //because i index will be same for every string, check if i inxed matches
                if (c != A.get(j).charAt(i))
                    return res;
            }
            //matched so add into res string
            res += c;
        }
        return res;
    }
}