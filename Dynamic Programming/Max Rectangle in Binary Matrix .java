public class Solution {
    int max_AreaRectangle(ArrayList<Integer> givenH){
        //O(n*m, n) using stacks
        //idea is to maintain max(increasing heights) indexes, into maxHst,
        // when encounter small height, take out top height index, and find difference of indexes and multiple by poped height
        //difference of index is (new smallH index - new Top index - 1)*poped height
        Stack<Integer> maxHst = new Stack<>();
        int maxArea=0;
        int n = givenH.size();
        for(int i=0;i < n;i++){
            while(!maxHst.isEmpty() && givenH.get(maxHst.peek()) > givenH.get(i)){
                //pop out recent max H index
                int recentMaxHIndex = maxHst.pop();
                //now if stack is empty, ist element
                if(maxHst.isEmpty()){
                    maxArea = Math.max(maxArea, i*givenH.get(recentMaxHIndex));
                }else{
                    // max height b/w prev maxHindex(maxHst.peek()) and current height index(excluding current and including prevMaxH so -1)
                    maxArea = Math.max(maxArea, (i-maxHst.peek()-1)*givenH.get(recentMaxHIndex));
                }
            }
            //add the new index/max height index anyway
            maxHst.push(i);
        }
        //after reaching end stack must be having some heights
        while(!maxHst.isEmpty()){
            int recentMaxHIndex = maxHst.pop();
            //now if stack is empty, ist element
            if(maxHst.isEmpty()){
                // want diff from (last index +1) to (prevmaxH index - 1) so length is last+1 already
                maxArea = Math.max(maxArea, n*givenH.get(recentMaxHIndex));
            }else{
            // want diff from (last index +1) to (prevmaxH index - 1) so length is last+1 already
                maxArea = Math.max(maxArea, (n-maxHst.peek()-1)*givenH.get(recentMaxHIndex));
            }
        }
        //final max area
        return maxArea;
    }

    public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
        int maxA = 0;
        // starting from 1st index, adding top only current is 1(then only) to judge final height col-wise
        for(int i=1;i < A.size();i++){
            for(int j=0;j < A.get(0).size();j++){
                if(A.get(i).get(j) > 0){
                    //add whatever top is to get max height
                    A.get(i).set(j, A.get(i).get(j) + A.get(i-1).get(j));
                }
            }
        }
        //now check max height/area for every row
        //could have updated max in the above loop also after modifying every row
        for(int i=0;i < A.size();i++){
            maxA = Math.max(maxA, max_AreaRectangle(A.get(i)));
        }

        return maxA;
    }
}
