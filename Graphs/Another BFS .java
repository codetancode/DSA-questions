public class Solution {
    // O(n+e, n)
    //idea is to add extra nodes in between of 2 nodes having high weight, for weight =2 add 1 node inbetween, for 3 add 2 nodes in b/w
    // make modefied adjList with added nodes, do BFS starting from start Node to target
    // each time storing the level of traversal in visited array
    //return target node's index in visited node to show on which level of bfs we found target node

    public int solve(int A, ArrayList<ArrayList<Integer>> B, int C, int D) {
    //adding extra nodes if weight is 2
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        Queue<Integer> bfsQ = new LinkedList<>();
        //if same node is target node
        if(C==D){
            return 0;
        }
        //we need to add additional nodes for 2 weights edges so
        int extraNode = A;
        //counting extra nodes
        for(int i=0;i < B.size();i++){
            if(B.get(i).get(2) == 2){
                extraNode++;
            }
        }
        //adding extra list in adj list for extra nodes
        for(int i=0;i < extraNode;i++){
            adjList.add(new ArrayList<>());
        }
        //for correct values of extra nodes reinit extraNode = A
        extraNode = A;
        for(int i=0;i < B.size();i++){
            if(B.get(i).get(2) == 2){

                //add extra node,
                //fromNode to extra node connection
                adjList.get(B.get(i).get(0)).add(extraNode);
                // also as undirected graph add to both the list
                adjList.get(extraNode).add(B.get(i).get(0));

                //extra node to toNode connection
                adjList.get(extraNode).add(B.get(i).get(1));
                // also as undirected graph add to both the list
                adjList.get(B.get(i).get(1)).add(extraNode);
                extraNode++;
            }else{
                //for weight =1 edges simple 2 way connection
                adjList.get(B.get(i).get(0)).add(B.get(i).get(1));
                adjList.get(B.get(i).get(1)).add(B.get(i).get(0));

            }
        }

        //forming visited level array for extra nodes , init by -1 for unvisited check
        ArrayList<Integer> visitedLevel = new ArrayList<Integer>(Collections.nCopies(extraNode, -1));
        //we need to go from C to D both <= A
        bfsQ.add(C);

        int lvlsize = 0;
        int lvl=1;
        while(!bfsQ.isEmpty()){
            lvlsize = bfsQ.size();
            //for 1st level from C
            while(lvlsize > 0){
                int newNode = bfsQ.poll();
                //if D found return lvl
                if(newNode == D){
                    return lvl;
                }
                for(Integer adjNode : adjList.get(newNode)){
                    //if the adjNode is not visited mark visited and add into bfsQ
                    if(visitedLevel.get(adjNode) == -1){
                        //if D found return lvl
                        if(adjNode == D){
                            return lvl;
                        }
                        visitedLevel.set(adjNode, lvl);
                        bfsQ.add(adjNode);
                    }
                }
                //reduce lvlnodes size
                lvlsize--;
            }
            //one lvl complete so increase lvl
            lvl++;
        }
        // as D will have level from C so return visited node index of D
        return visitedLevel.get(D);

    }
}

// static void showAdj(ArrayList<ArrayList<Integer>> adj){
    //     System.out.println();
    //     for(int i=0;i < adj.size();i++){
    //         System.out.println("For "+i);
    //         show(adj.get(i));
    //         System.out.println();
    //     }
    //     System.out.println();

    // }
    // static void show(ArrayList<Integer> a){
    //     for(int i=0;i < a.size();i++){
    //         System.out.print(a.get(i)+", ");
    //     }
    // }
