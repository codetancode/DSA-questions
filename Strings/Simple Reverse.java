public class Solution {
    //O(n, 1) or we could have used String builder
    //string reverse using char array
    public String solve(String A) {
        char[] a = A.toCharArray();
        rev(a, 0, A.length()-1);
        // char array to String is String.value of(charArray)
        return String.valueOf(a);
    }

    //normal rever function, i, j from both ends swppng
    static void rev(char[] a, int s, int e){
        char t;
        while(s < e){
            t = a[s];
            a[s] = a[e];
            a[e] = t;
            s++;
            e--;
        }
    }
}
