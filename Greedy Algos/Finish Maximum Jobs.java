public class Solution {
    //O(nlogn, n)
    //idea is to sort the jobs by their end times(for this created Pairs and implements Comparable for sorting by end time)
    //keep checking if endTime of current job is <= stTime of next job,
    // if their increase job counter, update last job end time to current job end time and continue
    //for this making a class pair implementing comparable<Pair>, for Collections.sort()
    class Pair implements Comparable<Pair>{
        int stTime;
        int endTime;
        Pair(int st, int end){
            this.stTime = st;
            this.endTime = end;
        }
        @Override
        public int compareTo(Pair n1) {
            // sorting based on end time
            return this.endTime - n1.endTime;
        }
    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Pair> jobsTime = new ArrayList<>();
        int maxJobCount = 1;
        //storing all jobs so that we can sort
        for(int i=0;i < A.size();i++){
            jobsTime.add(new Pair(A.get(i), B.get(i)));
        }
        //nlongn
        Collections.sort(jobsTime);
        //set 1st job, and set end time of 1st job variable
        int lastJobTime = jobsTime.get(0).endTime;
        for(int i=1;i < A.size();i++){
            //if new job st time<= last job end time, take new job, update values
            if(lastJobTime <= jobsTime.get(i).stTime){
                maxJobCount++;
                //set new end time
                lastJobTime = jobsTime.get(i).endTime;
            }
        }

        return maxJobCount;
    }
}
