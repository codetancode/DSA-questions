public class Solution {
    //O(n+e, n)
    //idea is to make adj list and call dfs on 1st node, as we need to find path b/w 1st and Ath node
    //in dfs keep current and target node, and mark visited node as true,
    // if currNode == targetNode, return true, check other nodes, if not visited and dfs is returning true, then return true,
    // default return false

    boolean dfs(int currNode, int tarNode, ArrayList<Boolean> visitedNodes, ArrayList<ArrayList<Integer>> AdjList){
        //mark this node visited
        visitedNodes.set(currNode, true);
        //if currNode == targetNode keep returning true
        if(currNode == tarNode){
            return true;
        }

        // for adj nodes to this currNode
        for(Integer i : AdjList.get(currNode)){
            //if not visited and dfs is returning true, return true
            if(!visitedNodes.get(i) && dfs(i, tarNode, visitedNodes, AdjList)){
                return true;
            }
        }
        //default return false
        return false;
    }
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        // creating boolean Visited array of A+1, as 0 based indexing
        //asn list of list for Adjlist for A nodes
        ArrayList<Boolean> visitedNodes = new ArrayList<>(Collections.nCopies(A+1, false));
        ArrayList<ArrayList<Integer>> AdjList = new ArrayList<ArrayList<Integer>>();

        //putting A+1 empty list for A nodes in Adjlist as 0 based indexing
        for(int i=0;i <= A;i++){
            AdjList.add(new ArrayList<>());
        }
        //filling the AdjList, with right nodes
        for(int i=0;i < B.size();i++){
            // B.get(i).get(0)- from node
            // B.get(i).get(1)- to node
            AdjList.get(B.get(i).get(0)).add(B.get(i).get(1));
        }

        //calling on 1 only coz if A exist it will be there else in dis connected anyway return false
        return dfs(1, A, visitedNodes, AdjList)?1:0;
    }
}
