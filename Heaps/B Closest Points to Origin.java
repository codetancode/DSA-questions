public class Solution {
    //O(n*logn, n)
    //having a class Pair to store x, y and its distance from origin
    //implementing comparator for pair, considering the distance from origin

    class Pair{
        int distanceFromO;
        int x;
        int y;
        //as distance From Origin sqrt(x2 + y2),
        //as its only distance no need to take sqrt(double to int lossy conversion error)
        Pair(int x,int y){
            //storing distance from origin
            this.distanceFromO = (x*x + y*y);
            this.x = x;
            this.y = y;
        }
    }
    //comparable of pair based on distance
    class CompPair implements Comparator<Pair>{
        public int compare(Pair a, Pair b){
            return a.distanceFromO - b.distanceFromO;
        }
    }

    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        PriorityQueue<Pair> minheap = new PriorityQueue<>(new CompPair());

        // fill all x, y given, distance is auto calculated in making pair obj
        for(int i=0;i < A.size();i++){
            minheap.add(new Pair(A.get(i).get(0), A.get(i).get(1)));
        }

        //take out 1st b elements put them in result ArrayList of ArrayList
        for(int i=0;i < B;i++){
            Pair lessDist = minheap.poll();
            res.add(new ArrayList<>( Arrays.asList(lessDist.x, lessDist.y) ));
        }

        return res;
    }
}
