public class Solution {
    //O(n, 1) traversal, and no space as its the out put only
    //taking a array list with a 0, keep adding sum at index 0, if after loop sum/carry is still 1, add 1 at 0 index again
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        ArrayList<Integer> res = new ArrayList<Integer>(Collections.nCopies(1, 0));
        int sum = 1;
        for(int i=A.size()-1;i >= 0;i--){
            sum += A.get(i);
            res.add(0, sum%10);
            sum/=10;
        }
        // if after loop sum/carry is still 1, add 1 at 0 index again
        if(sum > 0){
            res.add(0, sum%10);
        }
    //remove 0z from the result
        for(int i=0;i < A.size();i++){
            if(res.get(i) == 0){
                //if we found 0 remove it, and also do i--, for next time to check i index of modefied array
                res.remove((int)i);
                i--;
            }else{
                //non 0 element found so break out
                break;
            }
        }
        //remove that 0, we added from the start
        res.remove(res.size()-1);
        return res;
    }
}
