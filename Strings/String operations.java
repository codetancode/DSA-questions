public class Solution {
//O(n, 1)
//using string builder for quick String operations
    public String solve(String A) {
        //string operations
        HashSet<Character> vow = new HashSet<Character>();
        StringBuilder res = new StringBuilder();
        vow.add('a');
        vow.add('e');
        vow.add('i');
        vow.add('o');
        vow.add('u');
        for(int i=0;i < A.length();i++){
            //char.isLowerCase check and voewl set
            if(Character.isLowerCase(A.charAt(i)) && !vow.contains(A.charAt(i))){
                res.append(A.charAt(i));
            }
            if(vow.contains(A.charAt(i))){
                res.append('#');
            }
        }
        //res appended to itself
        res.append(res);

        return res.toString();
    }
}
