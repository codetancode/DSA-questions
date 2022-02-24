public class Solution {
    //O(n+e, n)
    //idea is to use DFS, keeping a path array and visited array of all nodes, keep doing dfs,
    // mark visited to path array and check if adjNodes are connecting back to path, if not reset current node
    //recursiveWay of finding a node already visited in a path
    boolean findNodeInPath(int currNode, ArrayList<Boolean> currPath, ArrayList<Boolean> visitedNodes, ArrayList<ArrayList<Integer>> AdjList){
        //marking gloabal visited
        visitedNodes.set(currNode, true);
        //also marking visited for current path for this node
        currPath.set(currNode, true);

        //goinf for all adj nodes of currNode
        for(Integer i : AdjList.get(currNode)){
            //if adjNode is a part of path, return cycle found
            if(currPath.get(i)){
                return true;
            }
            //if dfs from adj node returns true for cycle, return true for cycle from here
            if(!visitedNodes.get(i) && findNodeInPath(i, currPath, visitedNodes, AdjList)){
                return true;
            }
        }
        //take current node out of current path
        currPath.set(currNode, false);
        //as by now no cycle returned true so return false as no cycle
        return false;
    }
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Boolean> currPath = new ArrayList<>(Collections.nCopies(A+1, false));
        ArrayList<Boolean> visitedNodes = new ArrayList<>(Collections.nCopies(A+1, false));

        ArrayList<ArrayList<Integer>> AdjList = new ArrayList<ArrayList<Integer>>();
        //putting empty list for A nodes
        for(int i=0;i <= A;i++){
            AdjList.add(new ArrayList<>());
        }
        for(int i=0;i < B.size();i++){
            AdjList.get(B.get(i).get(0)).add(B.get(i).get(1));
        }

        //doing dfs for all nodes to check cycles
        for(int i=1;i <= A;i++){
            //if not visited and cycle found for any non visited node return
            if(!visitedNodes.get(i) && findNodeInPath(i, currPath, visitedNodes, AdjList)){
                return 1;
            }
        }
        return 0;

    }
}
