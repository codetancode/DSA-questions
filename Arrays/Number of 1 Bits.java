public class Solution {
    //moving number right counting &1==1, to check 1 at LSB
    public int numSetBits(int A) {
        int c=0;
        while(A > 0){
            // checking by anding from the LSB side and reducing actual number
            if((A & 1) == 1){
                c+=1;
            }
            A>>=1;
        }
        return c;

    }
}
