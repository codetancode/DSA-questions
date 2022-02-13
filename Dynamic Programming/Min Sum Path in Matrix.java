public class Solution {
    //O(n*m, n) Dp Solution, space optimized by taking 2 rows
    //idea is trying bottom up approach, from last row going up, and top left will have min cost
    // as oonly right and down move possible, updating last col with down values, and last row with its right values
    //for i, j cell, updating min(right and down)+current value
    public int minPathSum(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> currRow;
        ArrayList<Integer> bottomRow;
        int nRow = A.size()-1;
        int mCol = A.get(0).size()-1;
        //fill last row
        for(int j=mCol-1;j >= 0;j--){
            //if bottom row, with its right values
            A.get(nRow).set(j, A.get(nRow).get(j) + A.get(nRow).get(j+1));
            }
        //fill last col
        for(int j=nRow-1;j >= 0;j--){
            //if right most col, with its down value
            A.get(j).set(mCol, A.get(j).get(mCol) + A.get(j+1).get(mCol));
        }
        // from 2nd last row as current i, and i+ row as bottom row,
        // fill for col -1 element as last col is already filled
        for(int i=nRow-1;i >= 0;i--){
            currRow = A.get(i);
            bottomRow = A.get(i+1);
            for(int j=mCol-1;j>=0;j--){
                // for remaining i,j          min(right and down)+current value
            currRow.set(j, Math.min(currRow.get(j+1), bottomRow.get(j)) + currRow.get(j));

            }
        }
        //first cell will have the min cost
        return A.get(0).get(0);
    }
}
