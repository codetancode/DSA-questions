public class Solution {
    // O(n, 1) counting sort
    //as the elements are limited simply count number of elements and add them into array
    public int[] sortColors(int[] A) {
        int z = 0;
        int o = 0;
        int t = 0;
        int i=0;
        for(i=0;i < A.length;i++){
            if(A[i]==0){
                z++;
            }
            else if(A[i]==1){
                o++;
            }
            else if(A[i]==2){
                t++;
            }
        }
        i=0;
        while(z > 0 ){
            A[i++]=0;
            z--;
        }
        while(o > 0 ){
            A[i++]=1;
            o--;
        }
        while(t > 0 ){
            A[i++]=2;
            t--;

        }
        return A;
    }
}
