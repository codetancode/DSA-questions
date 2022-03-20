public class Solution {
    public int calculateMinimumHP(ArrayList<ArrayList<Integer>> A) {
        //O(n^2, n^2), for traversal and filling up possible health in cells
        //idea ist to find min health at each cell, starting from target coming back to top
        //since checking down and right, for last target cell, we ned extra col, and col
        ArrayList<ArrayList<Integer>> minHealth = new ArrayList<ArrayList<Integer>> ();
        int row = A.size();
        int col = A.get(0).size();
        for(int i=0;i < row + 1;i++){
            minHealth.add(new ArrayList<>(Collections.nCopies(col + 1, Integer.MAX_VALUE )));
        }
        //as we need atleast 1 health at target cell, filling right and down as 1
        minHealth.get(row-1).set(col, 1);
        minHealth.get(col-1).set(row, 1);

        // now filling minHealth with the help of A
        for(int i=row - 1;i >= 0;i--){
            for(int j=col - 1;j >= 0;j--){
                //                          min of down and right - current cell health in A
                int needHealth = Math.min(minHealth.get(i+1).get(j), minHealth.get(i).get(j+1)) - A.get(i).get(j);
                //if needHealht is -ve so atleast we need 1 health in every cell so
                minHealth.get(i).set(j, Math.max(1, needHealth));
            }
        }

        //asnwer will be at top
        return minHealth.get(0).get(0);
    }
}
