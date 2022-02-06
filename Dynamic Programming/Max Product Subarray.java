public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProduct(final List<Integer> A) {
        //kadane's algo
        //O(n, 1)
        //initilize all with 1st element
        int maxProd = A.get(0);
        int currMax=A.get(0);
        int currMin=A.get(0);

        for(int i=1;i < A.size();i++){
            //if -ve value found,
            // maxVal becomes min, and min val becomes maxval so swap
            if(A.get(i) < 0){
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }

            //currMax, currMin, contains max and min of sub array till A.get(i) so update them
            //icase currMin, currMin are 0(product will always be 0), so reset window with A.get(i)
            currMax = Math.max(currMax*A.get(i), A.get(i));
            currMin = Math.min(currMin*A.get(i), A.get(i));

            //as currmax will always have max val(did swaping earlier),
            //update answer with currmax
            maxProd = Math.max(currMax, maxProd);
        }

        return maxProd;
    }
}
