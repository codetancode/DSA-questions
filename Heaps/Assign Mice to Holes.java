public class Solution {
    //O(n*logn, 1) greedy
    //idea is to get the right values at right place to get smallest difference ,
    // we sort both the array and just take difference of values at indexes
    public int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
        HashSet<Integer> setOfOccupiedPlaces = new HashSet<Integer>();
        //sort positions of mice and position of holes, and taking index wise postion of mice and holes
        Collections.sort(A);
        Collections.sort(B);
        int overAllMinTime = Integer.MIN_VALUE;
        for(int i=0;i < A.size();i++){
            //considering one index in both at a time, so no need to check for index occupied or not
            int minTime = Math.abs(A.get(i) - B.get(i));
            overAllMinTime = Math.max(overAllMinTime, minTime);
        }

        return overAllMinTime;
    }
}
