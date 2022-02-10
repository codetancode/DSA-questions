public class Solution {
    //O(n*m*20)- through A, and B and max string len is 20
    //idea is simple brute force, for every string in B check if A has same length string,
    // if yes then check diff of char count in both string, if ==1 ,turn boolean to true, and if true break out of A's loop,
    // and update res for Bth string
    public String solve(ArrayList<String> A, ArrayList<String> B) {
        // StringBuilder sb = new StringBuilder();
        String res = "";
        //going through all B string
        for(int i=0;i < B.size();i++){
            boolean possible = false;
            //check with all A string
            for(int j=0;j < A.size();j++){
                //is same length string found in A, compare charDiff count
                if(B.get(i).length() == A.get(j).length()){
                    String tocheck = B.get(i);
                    String tocheckWith = A.get(j);
                    int diffCount = 0;
                    //check diff of char
                    for(int k = 0;k < tocheck.length();k++){
                        if(tocheck.charAt(k) != tocheckWith.charAt(k)){
                            diffCount++;
                        }
                    }
                    //if only 1 i.e found 1 string in A, so stop checking in A, break out of A loop
                    if(diffCount == 1){
                        possible = true;
                    }
                }
                // so stop checking in A, break out of A loop
                if(possible){
                 break;
                }
            }
            // update res after checking A strings
            if(possible){
                // sb.append("1");
                res+="1";
            }else{
                // sb.append("0");
                res+="0";
            }
        }
        //return string
        // return sb.toString();
        return res;
    }
}
