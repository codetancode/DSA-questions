public class Solution {
    //O(n, n) traversal, rl, lr array for around 1s count
    //idea is to make left to right and right to left prefix sum array of continous 1s, keeping a onez count(to know that we have extra on e to replace)
    // then traversing leaving 1 index from booth ends in A, and checking lr i-1 index current index and rl i+1 index,
    // also making sure total onez in A are more than around ones, so swap possible
    public int solve(String A) {
        int i=0;
        int n = A.length();
        int[] lr = new int[n];
        int[] rl = new int[n];
        //count onez to knoe we have 1 to replace
        int onez = 0;
        int max = Integer.MIN_VALUE;
        int res = 0;
        //make max 1z left to right arr lr, and right to left array rl
        for( i=0;i < n;i++){
            //for lr
            if(A.charAt(i) == '1'){
                //start index as 1 if its 1
                if(i == 0){
                    lr[0] = 1;
                }
                else{
                    //adding previous 1 + current 1
                    lr[i] = lr[i-1] + 1;
                }
                onez++;
            }
            else{
                //if current is 0, put 0 itself
                lr[i] = 0;
            }

            //for rl
            if(A.charAt(n-1-i) == '1'){
                if(n-1-i == n-1){
                    //for last index put 1
                    rl[n-1] = 1;
                }
                else{
                    //next + current 1
                    rl[n-1-i] = rl[n-1-i+1] + 1;
                }
            }
            else{
                //if 0 put 0 itself
                rl[n-1-i] = 0;
            }
        }
        //incase if total ones are 2 or less return them(as they could be together)
        if(A.length() <= 2){
            return onez;
        }

        //going through A to check left max 1s and right max 1s
        //checking A indexes excluding 1 element from both ends
        for(i=1;i < A.length()-1;i++){
            if(A.charAt(i) == '1'){
                //if 1, then left 1z + right 1z + current 1
                //so sum of lr previous index  + current 1 + rl next index
                max = Math.max(max, lr[i-1] + rl[i+1] + 1 );
            }
            else{
                //if 0, check if can swap, if right 1s + left 1s are less then total 1s
                //add extra 1 for possible swap
                //check if total onez are greater than around ones(lr -1 index, rl +1 index)
                if(lr[i-1] + rl[i+1] < onez){
                    //Swap possible
                    max = Math.max(max, lr[i-1] + rl[i+1] + 1);
                }
                else{
                    //if no swap then just total i around, 1 will get inb/w from either ends(total will be same)
                    max = Math.max(max, lr[i-1] + rl[i+1]);
                }
            }
        }

        return max;
    }
}
