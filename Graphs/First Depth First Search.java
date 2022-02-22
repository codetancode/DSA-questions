public class Solution {
    //O(n+e, n) space of visited\
    //making adj list of the given array, doing dfs from 1st node, if found target start returning true
    boolean dfs(int from, int to, ArrayList<ArrayList<Integer>> adjList, ArrayList<Boolean> visited){
        //if already visited return false
        if(visited.get(from)){
            return false;
        }
        //visit the node
        visited.set(from, true);
        //if this node is the target node return true from here
        if(from == to){
            return true;
        }

        //check and call dfs from all nodes
        for(Integer node : adjList.get(from)){
            //if true keep returning true
            if(dfs(node, to,  adjList, visited)){
                return true;
            }
        }
        //if not true after all nodes then return false
        return false;
    }
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(ArrayList<Integer> A, final int B, final int C) {
        ArrayList<Boolean> visited = new ArrayList<>(Collections.nCopies(A.size()+1, false));
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i <= A.size();i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i < A.size();i++){
            adjList.get(A.get(i)).add(i+1);
        }

        return dfs(C, B, adjList, visited)?1:0;
    }
}
