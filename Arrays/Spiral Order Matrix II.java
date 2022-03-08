public class Solution {
     public int[][] generateMatrix(int A) {
     //idea is looping from limits to limits, changing limits after loops, filling 2d array
        int[][] res = new int[A][A];
        int i=0;
        int k = 1;
        //4 variables, for keeping track of start and end of row and column
        int ro_s = 0;
        int co_s = 0;
        int ro_e = A-1;
        int co_e = A-1;
        //while row and col stays in limits
        while(ro_s <= ro_e && co_s <= co_e)
        {
            //first row
            i=co_s;
            while(i <= co_e && k <= A*A){
                res[ro_s][i++]=k;
                k++;
            }
            //as row filled so ro_s++
            ro_s++;

            //last column
            i=ro_s;
            while(i <= ro_e && k <= A*A){
                res[i++][co_e] = k;
                k++;
            }
            //as column filled column end --
            co_e--;

            //last row
            i=co_e;
            while(i >= co_s && k <= A*A){
                res[ro_e][i--] = k;
                k++;
            }
            //as row filled row_end --
            ro_e--;

            //first column
            i=ro_e;
            while(i >= ro_s && k <= A*A){
                res[i--][co_s] = k;
                k++;
            }
            //as first column filled so column_start ++
            co_s++;
        }

        return res;
    }
}
