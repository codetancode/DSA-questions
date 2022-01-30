public class Solution {
    public String solve(ArrayList<Integer> A) {
        //idea is to traverse from last and keep maintaining min and max, if next element is in the range break
        int n = A.size()-1;
        if(n >=1){
            //if size is=2 or more then run loop else return yess for 2 nodes
            int maxFrmBack = Math.max(A.get(n), A.get(n-1));
            int minFrmBack = Math.min(A.get(n), A.get(n-1));
            for(int i=n-2;i >= 0;i--){
                // if new element from last is in the range of min and max break
                if(A.get(i) < maxFrmBack && A.get(i) > minFrmBack){
                    return "NO";
                }else{
                    //update last min and max
                    maxFrmBack = Math.max(maxFrmBack, A.get(i));
                    minFrmBack = Math.min(minFrmBack, A.get(i));
                }
            }
        }
        return "YES";
    }

}
