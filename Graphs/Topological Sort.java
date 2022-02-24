public class Solution {
    //O(n+e, n)
    //can be done by both dfs and bfs, as order is req Lexographically smallest one.
    //using bfs
    //idea is to stoe levels into min Heap(as order is req.), and do bfs using visited array on adjList
    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        ArrayList<Integer> inDeg = new ArrayList<Integer>(Collections.nCopies(A+1, 0));
        PriorityQueue<Integer> setBFS = new PriorityQueue<>();

        //making adjList of given DAG,
        for(int i=0;i <= A;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i < B.size();i++){
            // and also keeping inDegree of all nodes
            inDeg.set(B.get(i).get(1) , inDeg.get(B.get(i).get(1)) + 1);
            adjList.get(B.get(i).get(0)).add(B.get(i).get(1));
        }

        //adding all nodes of inDegree 0 into min Heap, (node to which no one is pointing)
        for(int i=1;i <= A;i++){
            if(inDeg.get(i) == 0){
                setBFS.add(i);
            }
        }

        //while min heap has some nodes to visit
        while(!setBFS.isEmpty()){
            //pick minimum node as covered node
            int covered = setBFS.poll();
            // add it to result
            res.add(covered);
            //reducing indeg of adj nodes of this covered node
            for(int i=0;i < adjList.get(covered).size();i++){
                int adjNode = adjList.get(covered).get(i);
                inDeg.set(adjNode, inDeg.get(adjNode) - 1);
                //now if adjNode indeg reduced to 0(ready to be covered) add to BFS min heap
                if(inDeg.get(adjNode) == 0){
                    setBFS.add(adjNode);
                }
            }
        }

        //if not possible return empty list
        if(res.size() != A){
            return new ArrayList<>();
        }else{
            return res;
        }

    }
}
