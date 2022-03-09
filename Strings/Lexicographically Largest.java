public class Solution {
    //O(n, 1) as traversal on given n, and 26 sized freq array
    //idea is to make freq array of given char after _(Usable char),
    //now using j check largest char present in Usable char, and i starting from 0 in main,
    // replace first char of i with j, reducing j freq, and making main lexicographically largest
    public String getLargest(String A) {
        int i=0;
        int j=0;
        int[] frq = new int[26];

        //get _ index to get size
        while(A.charAt(i) != '_'){
            i++;
        }
        //create main of i size(_ index size)
        char[] main = new char[i];
        i++;
        //fill the frq array
        while(i < A.length()){
            frq[A.charAt(i)-'a']++;
            i++;
        }

        i=0;
        //fill main till _ index
        while(A.charAt(i) != '_'){
            main[i] = A.charAt(i);
            i++;
        }

        // now start i from begining of main, and j from last of freq array(replace i, j reduce j freq)
        i=0;
        j=25;
        while(i < main.length && j > 0){
            //for non exisitng char in frew, just j--
            while(frq[j] == 0 && j > 0){
                j--;
            }
            //if main has char smaller than j
            if(main[i]-'a' < j){
                // replace main char by j char to make main lexicographically largest
                main[i] = (char)(j+'a');
                //and reduce j's freq
                frq[j]--;
            }

            i++;
        }

        //convert char array to String
        return String.valueOf(main);
    }
}

