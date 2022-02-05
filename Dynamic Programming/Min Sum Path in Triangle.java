public class Solution {
    //bottom to top  approach
    // O(n*n, 1)(traversing all emenent, and using given input for space so 1)
    //idea is to go bottom to top, adding up min() path cost in rows(nextDown and nextDownNext),
    // finally will have answer at the top row as single element
    // [   1 in 1th row is next down to 1 in 0th row, and 2 in 1th row is nextdownnext to 1 in 0th row
    //     [1]
    //     [1, 2]
    //     [1, 2, 3]
    // ]

    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        int lastRowIndex = a.size()-1;
        //starting from 2nd last row, to all the way to top
        for(int row=lastRowIndex-1;row >= 0;row--){
            //both nextDown and nextDownNext will exist (while starting from 2nd last row and goinf to top)
            for(int col = 0;col < a.get(row).size();col++){
                int nextDown = a.get(row+1).get(col);
                int nextDownNext = a.get(row+1).get(col+1);
                int curr = a.get(row).get(col);
                //setting 2nd row values as minimum considering next ro values
                a.get(row).set(col, Math.min(curr + nextDown, curr + nextDownNext));
            }
        }

        // just return top element
        return a.get(0).get(0);
	}
}
