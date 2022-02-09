public class Solution {
    //O(n, n)using simple set of strings
    public ArrayList<Integer> solve(ArrayList<String> A, ArrayList<String> B) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        HashSet<String> setOfString = new HashSet<>();
        //fill dic words then check with B
        for(int i=0;i < A.size();i++){
            setOfString.add(A.get(i));
        }
        for(int i=0;i < B.size();i++){
            //if present then add 1 else add 0
            if(setOfString.contains(B.get(i))){
                res.add(1);
            }else{
                res.add(0);
            }
        }
        return res;
    }
}
