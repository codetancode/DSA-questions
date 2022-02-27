public class Solution {
    //O(e*logE, n) sorting and N for parent array
    //Kruskal algo using Disjoint set
    //idea is to keep track of edges not making connected components, and keep adding weights for such edges
    //sort the given edges as per wieghts, and keep adding then into the Disjoint Set, for not forming (cycle add weight and count edges)
    static int edges = 0;
    static int minCost = 0;

    static class DisJointUnion{
        ArrayList<Integer> parent;
        int size;
        DisJointUnion(int nodes){
            this.size = nodes+1;
            this.parent = new ArrayList<>();
            for(int i=0;i < size;i++){
                this.parent.add(i);
            }
        }
        //path compression algo. O(1) check
        //it updates all k node to its main 1 parent recursively
        private int root(int x){
            //if this node it self is a root
            // then its parent will be it only
            if(x == this.parent.get(x)){
                return x;
            }
            this.parent.set(x, root(this.parent.get(x)));
            return this.parent.get(x);
        }
        //check if 2 element belong to same set,  else add 2 new element into this set(join their roots)
        public boolean union(int x, int y, int w){
            int rootX = root(x);
            int rootY = root(y);

            //if parent root of both are same then they lie in same set  only so return false
            if(rootX == rootY){return false;}
            //if not then add them into same set
            //by joining their roots, we can do either this.parent[rootX] = rooY or this.parent[rootY] = rooX
            this.parent.set(rootX, rootY);
            //now as the edges is not forming cycle count edges and add global weights
            edges++;
            minCost += w;

            //true are they were not in same set
            return true;
        }
    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        //try Kruskal using disjoint set union
        //init DisJoinSet with a size A nodes
        DisJointUnion disUniSet = new DisJointUnion(A);
        //reset global counters
        minCost = 0;
        edges=0;
        //sort given edges basis weights
        Collections.sort(B, (al1, al2)->Integer.compare(al1.get(2), al2.get(2)));

        //as sorted weight edges, keep doing union of pair of edge till valid edges reaches A-1(all connected, not forming cycles)
        for(int i=0;i < B.size();i++){
            if(edges == A-1){
                return minCost;
            }
            //add pair of nodes and its weights, for edges making loop it will return false, else will add it
            disUniSet.union(B.get(i).get(0), B.get(i).get(1), B.get(i).get(2));
        }

        return minCost;
    }
}
