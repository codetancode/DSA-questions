public class Solution {
    //O(n*logn, n), coz sorting, and heap size
    //idea is to keep current time as a ref index of time form 0, keep adding profi into min heap, and go through the given ArrayList
    // if found time ran out for a bigger up coming profit, replace min heap peek with bigger profit.

    //for sorting profit with time
    static class Pair{
        int time;
        int profit;
        Pair(int t, int p){
            this.time = t;
            this.profit = p;
        }
    }
    //  class HelpCompare implements Comparator<Pair>{
    //     //comparing basis time, for sorting
    //     public int compareTo(Pair p1, Pair p2){
    //         return p2.time - p1.time;
    //     }
    // }
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Pair> timeProfit = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int profit = 0;
        int mod = 1000000007;

        //store time and profit to sort it wrt time
        for(int i=0;i < A.size();i++){
            timeProfit.add(new Pair(A.get(i), B.get(i)));
        }

        // sort with time
        Collections.sort(timeProfit, (p1, p2)->Integer.compare(p1.time,p2.time));
        // mainting current time just to select the car
        int currTime = 0;

        //go through the given queries
        for(int i=0;i < A.size();i++){
            //taking car in free, timm time permits add directly
            if(timeProfit.get(i).time > currTime){
                //buy the car and add current time
                minHeap.add(timeProfit.get(i).profit);
                currTime++;
            }else{
                //if cannot but the car coz of time, and new car giving more profit then prev small profit
                // replace it with previous low cost car
                if(timeProfit.get(i).profit > minHeap.peek()){
                    //if got car with high profit, replace old car in that old previous minute
                    minHeap.poll();
                    minHeap.add(timeProfit.get(i).profit);
                }
            }
        }

        //sum up all profit, stored in min heap
        while(!minHeap.isEmpty()){
            profit = profit + minHeap.poll();
            profit %= mod;
        }

        return profit;
    }
}
