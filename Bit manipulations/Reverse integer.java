public class Solution {
    public int reverse(int A) {
        // to check owerflow maintain a prev state integer
        //keep checking if new rev can be converted to prev state or not

        if(A < 0){
            return (-1)*rev(A*(-1));
        }
        else{
            return rev(A);
        }
    }
    static int rev (int a){
        int r=0;
        int prev = 0;
        while(a > 0){
            r = r*10 + a%10;

            if((r-a%10)/10 != prev){
                return 0;
            }
            prev = r;
            a/=10;
        }

        return r;
    }
}
