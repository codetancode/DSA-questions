public class Solution {
    //dp O(n, n)- space as using additional array, but can be optimized to 1
    //idea is to take max out of both top and bottom,
    // then apply the concept of take it and leave it int the array
    //take it or leave it comcept, going from left to right maintaining max sum
    //max of (curr ele + (curr-2th ele), (curr-1)th ele)
    public int adjacent(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        //adding 0 for reference
        res.add(0);
        for(int i=0;i < A.get(0).size();i++){
            // storing max of top and bottom
            res.add(Math.max(A.get(0).get(i), A.get(1).get(i)));
        }

        // starting from 2nd index as array is [ 0, 1stElem, 2ndElem .. ]
        for(int i=2;i < A.get(0).size()+1;i++){
            //selecting and rejecting based on max value, either curr + prev prev sum, or just prev sum continues
            int currPrevPrevSum = res.get(i)+res.get(i-2);
            int curPrevSum = res.get(i-1);
            res.set(i, Math.max(curPrevSum, currPrevPrevSum));
        }

        //last element in res will be added max sum
        return res.get(res.size()-1);
    }
}
