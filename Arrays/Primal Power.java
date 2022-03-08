public class Solution {
    //counting primes
    public int solve(int[] A) {
        int res = 0;
        for(int i=0;i < A.length;i++){
            if(prime(A[i])){
                res++;
            }
        }
        return(res);
    }

    static boolean prime(int a){
        if(a < 2){
            return false;
        }
        else if(a == 2){
            return true;
        }
        else{
            //if even number not prime
            if( (a & 1) != 1 ){
                return false;
            }
            int i=2;
            //loop till sqrt of given no., if divisible not prime
            while(i <= Math.sqrt(a)){
                if(a%i == 0){
                    return false;
                }
                i++;
            }
        return true;
        }

    }
}
