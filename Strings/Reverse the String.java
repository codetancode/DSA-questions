public class Solution {
    //o(n, 1)
    //idea is to take String asn char Array and first reverse entire string, then just reverse till spaces
    public String solve(String A) {
        char[] carr = A.toCharArray();
        //rev entire string/char array
        rev(carr, 0, A.length()-1);
        int n = A.length();
        int i = 0;
        int j=0;

        while(i < n && j < n){
            while(j < n && carr[j] != ' '){
                j++;
            }
            int t=j;
            j--;
            //reverse till 1 index before space char(rev words)
            rev(carr, i, j);
            //take care of indexing
            i=t+1;
            j=t+1;
        }

        //return String from Char array
        return String.valueOf(carr);
    }

    //simple rev function
    static void rev(char[] a, int s, int e){
        char t;
        if(a[s]==' '){s++;}
        if(a[e]==' '){e--;}

        while(s < e){
            t = a[s];
            a[s] = a[e];
            a[e] = t;
            s++;
            e--;
        }
    }
}
