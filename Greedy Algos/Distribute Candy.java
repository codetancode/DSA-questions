public class Solution {
    // O(n, n)
    //idea is to go left to right giving higher candy to the higher rating
    //and then right to left following same thing, keeping max( of given candy , have to give candy)
    public int candy(ArrayList<Integer> A) {
        ArrayList<Integer> candyDistribution = new ArrayList<Integer> ();
        int totalCandy = 0;
        //just for convenience add elements in 1st loop
        candyDistribution.add(1);
        for(int i=1;i < A.size();i++){
            //from left to right, if curr val is higher than prev,
            // put prev candy + 1 higher in current
            if(A.get(i) > A.get(i-1)){
                candyDistribution.add(candyDistribution.get(i-1)+1);
            }else{
                //else for smaller values atleast 1 candy
                candyDistribution.add(1);
            }
        }
        //now checking from right to left
        for(int i=A.size()-2;i >=0;i--){
            // if current value is greater than the next val,
            // ideally curr could just be next candy +1, but incase current already has higher candies(from left to right),
            // so put max out of these
            if(A.get(i) > A.get(i+1)){
                candyDistribution.set(i, Math.max(candyDistribution.get(i+1)+1, candyDistribution.get(i)));
            }
            // else no change as all fit as we came left to right
        }

        //total sum
        for(int i=0;i < A.size();i++){
            totalCandy+=candyDistribution.get(i);
        }
        return totalCandy;
    }
}
