public class Solution {
    //she picks box with candies , B, and doesnot repeat same box again
    //after eating from 1 box, she put remaining /2 candy in smallest candy box available at that time
    public int solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        int totalCandyEaten = 0;
        // adding all in min heap
        for(int i=0;i < A.size();i++){
            minheap.add(A.get(i));
        }
        // while top-min of heap < B mesha could eat , also size > 1
        while(minheap.peek() <= B && minheap.size() > 1){
            int smallestBox = minheap.poll();
            //eat
            totalCandyEaten += smallestBox/2;
            int remaingToadd;
            //if last even simple half, if odd half +1 to add
            if(smallestBox%2 == 0){
                remaingToadd = smallestBox/2;
            }else{
                remaingToadd = smallestBox/2 + 1;
            }
            //eats half and put remaining in nextsmallestBox
            int nextsmallestBox = minheap.poll();
            minheap.add(nextsmallestBox + remaingToadd);
        }

        //for last element
        if(minheap.peek() <= B){
            int smallestBox = minheap.poll();
            //eat
            totalCandyEaten += smallestBox/2;
        }

        return totalCandyEaten;

    }
}
