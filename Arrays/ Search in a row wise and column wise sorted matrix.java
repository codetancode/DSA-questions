public class Solution {
    //as sorted , traverse the matrix starting from top right i=0, j=length-1
    public int solve(int[][] A, int B) {
        int res =0;
        int i=0;
        int j=A[0].length -1;

        //starting from top right i=0, j=lenght-1
        while(i < A.length && j >= 0 ){
            if(A[i][j] == B){
                //if found go left, by j--, if duplicates, go to 1st one form left
                while(j-1 >= 0 && A[i][j-1] == B){
                    j--;
                    }

                return (i+1)*(1009)+(j+1);
            }
            //if bigger go right
            else if(A[i][j] > B){
                j--;
            }
            else{//if smaller go down
                i++;
            }

        }
        return -1;
    }
}
