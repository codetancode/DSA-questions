public class Solution {
    //O(n+e, n) color for n nodes
    //idea is to amke adj list both side, as undirected graph, unconnected graph,
    //as un connected for every node if color not initlizd, initilize color for a node and call dfs on that node

    boolean biPertiteCheck(int currNode, ArrayList<ArrayList<Integer>> adjList, ArrayList<Integer> color){
        //for every connected node
        for(Integer node: adjList.get(currNode)){
            // if color to that node is assigned set different color that the color of current node1^currentNode color
            if(color.get(node) == -1){
                color.set(node, 1^color.get(currNode));
                //call function on that node if false for that node return false
                if(!biPertiteCheck(node, adjList, color)){
                    return false;
                }
                //if color of this node is same as current node, then return false
            }else if(color.get(node) == color.get(currNode)){
                return false;
            }
        }
        //if all right return true
        return true;
    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> color = new ArrayList<>(Collections.nCopies(A+1, -1));

        //fill adj list
        for(int i=0;i <= A;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i < B.size();i++){
            adjList.get(B.get(i).get(0)).add(B.get(i).get(1));
            //as Undirected graph so adding in both node list
            adjList.get(B.get(i).get(1)).add(B.get(i).get(0));

        }

        //as unconnected check for all nodes
        for(int i=1;i <= A;i++){
            //start node color if not already assigned
            if(color.get(i) == -1){
                color.set(i, 0);
            }
            //then sent start node, if for any false return false
            if(!biPertiteCheck(i, adjList, color)){
                return 0;
            }
        }
        return 1;
    }
}
