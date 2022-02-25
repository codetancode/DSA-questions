public class Solution {
    //O(e*loge, e) for edges and heap
    //Prims (construct Minimum spanning tree using min heap for weights edges and breaking as soon as we get A-1 edges)
    static class Pair{
        int toNode;
        int cost;
        Pair(int j, int w){
            this.toNode = j;
            this.cost = w;
        }
    }
    class HelpCompare implements Comparator<Pair>{
        public int compare(Pair p1, Pair p2){
            return p1.cost - p2.cost;
        }
    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        //adjlist of Pair(to Node and weights)
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<ArrayList<Pair>>();
        PriorityQueue<Pair> minHeapOfLowCostEdge = new PriorityQueue<>(new HelpCompare());
        ArrayList<Boolean> visited = new ArrayList<>(Collections.nCopies(A+1, false));
        long minCost = 0;
        long mod = 1000000007;
        //1 exceptions for 1 node
        if(A == 1){return 0;}
        //fill adjlist
        for(int i=0;i <= A;i++){
            adjList.add(new ArrayList());
        }
        //storing all the edges with their weights in ascending order
        for(int i=0;i < B.size();i++){
            //as undirected graph add pairs into both
            adjList.get(B.get(i).get(0)).add(new Pair(B.get(i).get(1), B.get(i).get(2)));
            adjList.get(B.get(i).get(1)).add(new Pair(B.get(i).get(0), B.get(i).get(2)));
            //storing edges from 1 into the map

            //selecting b(0, 0) and adding all edges from b(0, 0)
            //add both edges from b(0, 0) to toNode, and toNode to 1
            if(B.get(i).get(0) == B.get(0).get(0)){
                minHeapOfLowCostEdge.add(new Pair(B.get(i).get(1), B.get(i).get(2)));
            }
            //and toNode to b(0, 0)
            if(B.get(i).get(1) == B.get(0).get(0)){
                minHeapOfLowCostEdge.add(new Pair(B.get(i).get(0), B.get(i).get(2)));
            }
        }
        //marking b(0, 0) as visited, as starting from it
        visited.set(B.get(0).get(0), true);

        //we only need to hop A-1 steps of min weight edges
        int hops=0;
        while(hops != A-1){
            Pair minNodeWeight = minHeapOfLowCostEdge.poll();
            //if node is not visited, take than node (as we already know it would be min weights only due to heap)
            if(!visited.get(minNodeWeight.toNode)){
                //as next selected node as visited, and add all its adj nodes into heap
                visited.set(minNodeWeight.toNode, true);
                //updating the cost
                minCost = (minCost + minNodeWeight.cost)%mod;
                //as now we selected this unvisited node visited so hop++
                hops++;
                //add all its adj nodes into heap
                for(Pair adjNode : adjList.get(minNodeWeight.toNode)){
                    minHeapOfLowCostEdge.add(new Pair(adjNode.toNode, adjNode.cost));
                }
            }
        }
        return (int)(minCost%mod);
    }
}
