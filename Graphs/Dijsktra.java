public class Solution {

    //Dijskrta Algo- idea is to keep a distance from source array on all Nodes, using heap select the edges with less weights
    //keep updating the array of distance from sorce.

    static class Pair{
        int toNode;
        int weight;
        Pair(int n, int w){
            this.toNode = n;
            this.weight = w;
        }
    }
    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B, int C) {
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<ArrayList<Pair>>();
        ArrayList<Boolean> visited = new ArrayList<Boolean>(Collections.nCopies(A, false));

        PriorityQueue<Pair> minHeapWeights = new PriorityQueue<>((p1, p2)->Integer.compare(p1.weight, p2.weight));
        ArrayList<Integer> distFromSrc = new ArrayList<>(Collections.nCopies(A, -1));
        //marking source node distance from source node as 0
        distFromSrc.set(C, 0);


        for(int i=0;i < A;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i < B.size();i++){
            //other adj node and weights
            adjList.get(B.get(i).get(0)).add(new Pair(B.get(i).get(1), B.get(i).get(2)));
            adjList.get(B.get(i).get(1)).add(new Pair(B.get(i).get(0), B.get(i).get(2)));

            //storing edges of source C into min heap
            //edges from C
            if(B.get(i).get(0) == C){
                //storing tonode and weights
                minHeapWeights.add(new Pair(B.get(i).get(1), B.get(i).get(2)));
            }
            //edges to C
            if(B.get(i).get(1) == C){
                //storing fromNode and weights
                minHeapWeights.add(new Pair(B.get(i).get(0), B.get(i).get(2)));
            }
        }
        //mark source node visited
        visited.set(C, true);


        while(!minHeapWeights.isEmpty()){
            Pair minWeightEdge = minHeapWeights.poll();
            int otherNode = minWeightEdge.toNode;
            int otherNodeW = minWeightEdge.weight;

            //if other node is unvisited
            if(!visited.get(otherNode)){
                //marking other adkNode as visited and
                visited.set(otherNode, true);
                // updating the distance from src array. to min of old value and other Node Weight
                distFromSrc.set(otherNode, otherNodeW);
                //adding adj nodes to this nodes into min heap
                for(Pair adjNode : adjList.get(otherNode)){
                    //now as this other node is visited and weights is updated with its weight + adjNodes weight
                    minHeapWeights.add(new Pair(adjNode.toNode, otherNodeW + adjNode.weight));
                }
            }
        }

        return distFromSrc;
    }
}
