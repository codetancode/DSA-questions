public class Solution {
    public void solve(int[][] A) {
    //given Nxn matrix clockwise rotations
    //picking corner item swaping and doing this in b/w the row/column boundries
      int i=0;
      int j=0;
      int temp=0;
      //going layer by layer so len/2
      for(i=0;i < ( A.length/2);i++){
        //   picking elements from row considering both ends
          for(j=i;j < A.length-1-i;j++){
            //   picking top right elements in temp
              temp = A[j][A.length -1-i];
            //   storing bottom last elements in top right
              A[j][A.length -1-i] = A[i][j];
            //   putting (old) top right temp into last bottom, and keeping last bottom value in temp
              temp = swap(A, A.length -1-i,A.length -1-j , temp);
            //   putting last bottom value into last left, and picking last left value in temp
              temp = swap(A, A.length -1-j, i, temp);
            //   finally putting last left value in current i, j
              A[i][j] = temp;
          }
      }

    }

    //swap function puts temp in i, j and return swaped i, j value
    static int swap(int[][] a, int i, int j, int temp){
        int t = temp;
        temp = a[i][j];
        a[i][j] = t;
        return temp;
    }

}
