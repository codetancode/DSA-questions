public class Solution {
    //O(e, n) traversing over the edges and DUS parent array of n nodes
    //idea is similar to finding connections b/w 2 node and counting it as set, so DSU for fav flavours
    class DSU{
        ArrayList<Integer> parent;
        DSU(int size){
            this.parent = new ArrayList<>();
            for(int i=0;i < size+1;i++){
                this.parent.add(i);
            }
        }

        //applying path reduction in roots
        public int root(int x){
            if(x == this.parent.get(x)){
                return x;
            }
            //setting intermedeate parent of x (this.parent.set(x, )  to final root recursively(root(this.parent.get(x)))
            this.parent.set(x, root(this.parent.get(x)));
            // returning parent of x
            return this.parent.get(x);
        }
        public boolean union(int x, int y){
            if(x == y){
                return false;
            }
            int rootX = root(x);
            int rootY = root(y);

            if(rootX == rootY){
                return false;
            }
            //else union
            this.parent.set(rootX, rootY);

            return true;
        }
    }
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        DSU dsu = new DSU(A);
        int sadPPl=0;
        for(int i=0;i < B.size();i++){
            //if already eaten 2 flavours for this i guest, i will be sad
            if(!dsu.union(B.get(i).get(0), B.get(i).get(1))){
                sadPPl++;
            }
        }

        return sadPPl;
    }
}
