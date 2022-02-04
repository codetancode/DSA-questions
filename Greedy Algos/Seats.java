public class Solution {
    //O(n, k)
    //storing and finding median of total x in an array,
    //finding distance from median using the array

    public int seats(String A) {
        ArrayList<Integer> xindexes = new ArrayList<Integer>();
        int totalx = 0;
        int mod = 10000003;//given in qstn
        int median=0;
        int totalJumps = 0;
        //staoring all x and keeping relative index on x in xindex array
        for(int i=0;i < A.length();i++){
            if(A.charAt(i) == 'x'){
                //storing intermedeate indexs to get the median of x
                xindexes.add(i-totalx);
                totalx++;
            }
        }
        //if no x found in string
        if(totalx == 0){
            return 0;
        }

        //median index of found x in xindexes is (totalx-1/2)
        int med_Index = (totalx-1)/2;
        median = xindexes.get(med_Index);
        for(int i=0;i < xindexes.size();i++){
            // finding distance from median using the xindex array
            totalJumps = totalJumps%mod + Math.abs(xindexes.get(i) - median)%mod;
        }

        return totalJumps%mod;
    }
}
