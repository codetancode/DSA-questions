public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lis(final List<Integer> A) {
        //O(n^2, n), could reduce space
        //idea is to keep max len array considering a point for increasing seq. for every i,
        // then for every new element go back and keep checking if a small value having max increasing length is there or not
        //if there add curr element into len,
        //finally get max of maxLen array
        //minimum max len could be 1 so initilize with 1
        int maxLen = 1;
        ArrayList<Integer> prevLen = new ArrayList<Integer>();
        for(int i=0;i < A.size();i++){
            if(i == 0){
            //for 1st index no prev
                prevLen.add(1);
            }else{
            //we need to find max preLen and element should be < current element
            //having 2 variable, prevMaxLen,
            int prevMaxLen = 1;
            boolean foundPrevSmall = false;
            int goBacknCheck = i;
            //going back loop till 0, storing maxPrev len
            while( goBacknCheck >= 0 ){
                //if a small element found, check if its len is max or not,
                if(A.get(goBacknCheck) < A.get(i)){
                    //if prevlen+current element forms a max lenght then only update,
                    if(prevLen.get(goBacknCheck) + 1 > prevMaxLen ){
                        // if max then update  prevmax len
                        prevMaxLen = prevLen.get(goBacknCheck);
                        foundPrevSmall=true;
                    }
                }
                goBacknCheck--;
            }
            //after loop if prevSmallIndex value found then only update curr ln +1 else keep 1
            if(foundPrevSmall){
                prevLen.add(prevMaxLen + 1);
            }else{
                //add same 1, if no small value found earlier
                prevLen.add(prevMaxLen);
            }
            //updating answer
            maxLen = Math.max(maxLen, prevLen.get(i));
            }
        }

        return maxLen;
    }
}
