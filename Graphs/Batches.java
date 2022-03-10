public class Solution {
    //O(n+e, n) as dfs
    //using DFS to find sum of all connected components, using adjMap for given Nodes, and visited set
    //if a node is not visited and dfs Sum from that node is >= D , count a batch
    int dfs(int currNode, int[] value, HashSet<Integer> visitedSet, HashMap<Integer, ArrayList<Integer>> adjMap){
        if(visitedSet.contains(currNode)){
            return 0;
        }
        //mark visited
        visitedSet.add(currNode);

        //get this node sum from given value B
        int sum = value[currNode - 1];
        for(Integer i: adjMap.get(currNode)){
            if(!visitedSet.contains(i) ){
                sum += dfs(i, value, visitedSet, adjMap);
            }
        }
        // returning sum from dfs traversal
        return sum;

    }

    void makeAdjMap(HashMap<Integer, ArrayList<Integer>> adjMap, int A, int edges[][]){
        //as unconnected first put arrays for total nodes
        for(int i=1;i <= A;i++){
            adjMap.put(i, new ArrayList<>());
        }
        //then fill as per the sdges given
        for(int i=0;i < edges.length;i++){
            int frmNode = edges[i][0];
            int toNode = edges[i][1];

            //as undirected so both side fill
            adjMap.get(frmNode).add(toNode);
            adjMap.get(toNode).add(frmNode);
        }
    }

    public int solve(int A, int[] B, int[][] C, int D) {
        HashMap<Integer, ArrayList<Integer>> adjMap = new HashMap<>();
        HashSet<Integer> visitedSet = new HashSet<>();
        int res=0;

        makeAdjMap(adjMap, A, C);

        for(int i=1;i <= A;i++){
            //if node unvisited and has dfs sum value >= D, count a batch
            if(!visitedSet.contains(i) && dfs(i, B, visitedSet, adjMap) >= D){
                res++;
            }
        }

       return res;
    }


}
