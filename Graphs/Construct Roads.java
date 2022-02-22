public class Solution {
    //O(n+e, n)
    //idea is to take a color array for every node and mark 0 and 1 along with traversal as connected,
    //after dividing all nodes into 2 set, just apply the formula (no. of 1s color)*(no. of 0s color) - (A-1 present edges)
    //fill color array with 0s and 1s
    void biPertiteDivision(int currNode, ArrayList<Integer> color, ArrayList<ArrayList<Integer>> adjList){
        for(Integer node : adjList.get(currNode)){
            //if not set color
            if(color.get(node) == -1){
                //set color 1^0,
                color.set(node, 1^color.get(currNode));
                //make a dfs call for this node
                biPertiteDivision(node, color, adjList);
            }
        }
    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> color = new ArrayList<Integer>(Collections.nCopies(A+1, -1));
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>> ();
        //make adjlist
        for(int i=0;i <= A;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i < B.size();i++){
            adjList.get(B.get(i).get(0)).add(B.get(i).get(1));
            //both ways as undirected graph
            adjList.get(B.get(i).get(1)).add(B.get(i).get(0));
        }

       //initiate 1st node with a color and call df from it
        color.set(1, 0);
        //as connected graph, just call from 1 node only to cover all nodes
        biPertiteDivision(1, color, adjList);

        // count eiter 0s or 1s and subtract to get other
        long set1Count = 0;
        long mod = 1000000007;
        for(int i=1;i <= A;i++){
            // count 1s, so 0s are A-is
            if(color.get(i) == 1){
                set1Count++;
            }
        }
        //apply the formula total possible edges bw 2 sets elements - already given edges
        return (int)(((set1Count%mod)*(A-set1Count%mod))%mod - (A-1)%mod );
    }
}
