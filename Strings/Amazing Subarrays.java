public class Solution {
//O(n, 1)
    public int solve(String A) {
        //number of sub String fromm i index in len n String will be n-i
        HashSet<Character> vow = new HashSet<Character>();
        int res=0;
        int mod = 10003;
        int n=A.length();
        vow.add('a');
        vow.add('e');
        vow.add('i');
        vow.add('o');
        vow.add('u');

        for(int i=0;i < A.length();i++){
            //if at i, char is vouwel, total subString starting from this char in a string of len n would be n-i
            if(vow.contains(Character.toLowerCase(A.charAt(i)))){
                res+=n-i;
                res%=mod;
            }
        }

        return res;
    }
}
