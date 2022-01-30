public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        //keeping a max heap of size 3, poll 3 variable and push them back, along with new elements, it will have 3 max values at top
        // for <2 add -1, for others add product of 3 max values(as new elements are also being added)
        PriorityQueue<Integer> heap3 = new PriorityQueue<>(3, Collections.reverseOrder());
        ArrayList<Integer> res=new ArrayList<Integer>();

        for(int i=0;i<A.size();i++){
            //keepadding new element
            heap3.add(A.get(i));

            if(i < 2){
                res.add(-1);
            }else{
                //take out max 3 and add them back(anyway heap will only take max values)
                int a=heap3.poll();
                int b=heap3.poll();
                int c=heap3.poll();
                heap3.add(a);
                heap3.add(b);
                heap3.add(c);
                res.add(a*b*c);
            }
        }
        return res;
    }
}