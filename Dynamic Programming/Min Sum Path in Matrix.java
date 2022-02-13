public class Solution {
    //O(n*m, n*m) Dp Solution, space could be optimized by taking 2 rows
    //idea is trying bottom up approach, from last row going up, and top left will have min cost
    // as oonly right and down move possible, updating last col with down values, and last row with its right values
    //for i, j cell, updating min(right and down)+current value
    public int minPathSum(ArrayList<ArrayList<Integer>> A) {
        // ArrayList<Integer> bottomRow; = new ArrayList<Integer>();
        // ArrayList<Integer> currRow; = new ArrayList<Integer>();
        int nRow = A.size()-1;
        int mCol = A.get(0).size()-1;
        for(int i=nRow;i >= 0;i--){
            for(int j=mCol;j >= 0;j--){
                //if target cell skip
                if(i == nRow && j == mCol){
                    continue;
                }else if(j == mCol){
                //if right most col, with its down value
                    A.get(i).set(j, A.get(i).get(j) + A.get(i+1).get(j));
                }else if(i == nRow){
                //if bottom row, with its right values
                    A.get(i).set(j, A.get(i).get(j) + A.get(i).get(j+1));
                }else{
                    // for remaining i,j          min(right and down)+current value
                    A.get(i).set(j, Math.min(A.get(i).get(j+1), A.get(i+1).get(j)) + A.get(i).get(j));
                }
            }
        }
        //first cell will have the min cost
        return A.get(0).get(0);
    }
}
