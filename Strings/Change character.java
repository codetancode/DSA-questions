public class Solution {
    //O(n, 1) as soriting of contact 26,
    //idea is to take a freq array and fill it with char count.
    // sort it so that we can consider B counts of removable keys
    //keeping total removable count to <=B, finally return total keys - removable keys
    //if B is very high alteast 1 char will be distinct
    public int solve(String A, int B) {
        // char freq array
        int[] fq = new int[26];
        int i=0;
        //total char
        int keys=0;
        //removable char
        int cremove = 0;
        int n=A.length();
        // count of removable char
        int reduce_f = 0;
        //filling frq array, char counts
        for(i=0;i < n;i++){
            fq[A.charAt(i)-'a']++;
        }
        //sorting freq array, Constant time as 26 is fixed
        Arrays.sort(fq);

        i=0;
        while(reduce_f <= B && i < 26){
            // if char is present
            if(fq[i] > 0){
                //add up its freq as it can be replaces
                reduce_f += fq[i];
                cremove++;
            }
            i++;
        }
        //reducing extra freq count of a char from reduce_f, incase reduce_f > B
        if(i < 26 && reduce_f > B){
            reduce_f -= fq[i];
            cremove--;
        }

        //now counting total char
        i=0;
        while(i < 26){
            if(fq[i] > 0){
                keys++;
            }
            i++;
        }

        //if total keys is same as removable keys then return 1(as their will we atleast 1 distinct char)
        if(keys-cremove == 0){
            return 1;
        }
            //else return total - removable keys
            return keys-cremove;
        }
}
