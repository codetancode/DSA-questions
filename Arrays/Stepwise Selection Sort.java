public class Solution {
    //simple selection sort
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int i=0;
        int k=0;
        int min=Integer.MAX_VALUE;
        int n = A.size();
        //as for n-1 elements
        for(i=0;i < n-1;i++){
            //go from i to n looking for min element
            for(int j=i;j < n;j++){
                if(min > A.get(j)){
                    min = A.get(j);
                    k=j;
                }
            }
            //add minimum index in result
            res.add(k);
            //swap i with min value found from i to n(in j loop)
            sw(A, i, k);
            //reset min to max
            min = Integer.MAX_VALUE;
        }
        return res;
    }

    //swapping func.
    static void sw(ArrayList<Integer> a, int i, int j){
        int t = a.get(i);
        a.set(i, a.get(j));
        a.set(j, t);
    }
}
