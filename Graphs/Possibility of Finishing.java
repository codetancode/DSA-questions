public class Solution {
    //O(n+e, n) visited array space
    //using DFS back trackand put into stack, if stack size == given n nodes possible else not
    //starting from any node
    boolean dfsToCheckCycle(int currNode, ArrayList<Boolean> visited, ArrayList<Boolean> currPath, ArrayList<ArrayList<Integer>> adjList){
        // first mark node visited in visited
        visited.set(currNode, true);
        // and also its in current path now so currPath of currNode == true
        currPath.set(currNode, true);

        if(adjList.get(currNode).size() > 0){
            for(Integer node : adjList.get(currNode)){
                //for all adj nodes if they are in curr path i.e their is a cycle
                if(currPath.get(node)){
                    return true;
                }
                //if dfsToCheckCycle for this node is returning true set return true from here
                if(dfsToCheckCycle(node, visited, currPath, adjList)){
                    return true;
                }
            }
        }
        //if nothing returned true aboe then now mark out the current node from path
        // and return false for cycle
        currPath.set(currNode, false);
        return false;
    }
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        // B- required course
        // C- to complete course
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Boolean> visited = new ArrayList<>(Collections.nCopies(A+1, false));
        ArrayList<Boolean> currPath = new ArrayList<>(Collections.nCopies(A+1, false));
        boolean cycleFound = false;
        for(int i=0;i <= A;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i < B.size();i++){
            adjList.get(B.get(i)).add(C.get(i));
        }
        //calling dfs on all un visited node
        for(int i=1;i <= A;i++){
            if(!visited.get(i)){
                //check from any node cycle found once
                cycleFound = dfsToCheckCycle(i, visited, currPath, adjList);
            }
            //if yes return 0 directly
            if(cycleFound){
                return 0;
            }
        }

        //if no cycle found till now return possible
        return 1;
    }
}
