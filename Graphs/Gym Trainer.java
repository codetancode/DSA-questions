public class Solution {
    //O(e*logE, n) sorting and N for parent array
    //Kruskal algo using Disjoint set
    //idea is to check for common nodes in B and C, if there return. in the end using DSU,
    // check nodes having common parent/forming group/part having same root nodes of a set using parent array of DSU
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
        public int root(int x){
            //if this node it self is a root
            // then its parent will be it only
            if(x == this.parent.get(x)){
                return x;
            }
            this.parent.set(x, root(this.parent.get(x)));
            return this.parent.get(x);
        }
        //check if 2 element belong to same set,  else add 2 new element into this set(join their roots)
        public boolean union(int x, int y){
            int rootX = root(x);
            int rootY = root(y);

            //if parent root of both are same then they lie in same set  only so return false
            if(rootX == rootY){return false;}
            //if not then add them into same set
            //by joining their roots, we can do either this.parent[rootX] = rooY or this.parent[rootY] = rooX
            this.parent.set(rootX, rootY);


            //true are they were not in same set
            return true;
        }
    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B, ArrayList<ArrayList<Integer>> C) {
        DisJointUnion DSU = new DisJointUnion(A);
        // check for common nodes in B and C
        HashSet<Integer> typeOfppl = new HashSet<>();
        for(int i=0;i < B.size();i++){
            // from u to v
            int u = B.get(i).get(0);
            int v = B.get(i).get(1);
            //add both u and v into set for latter checking with C given queries
            typeOfppl.add(u);
            typeOfppl.add(v);
            //add ppl in DUS
            DSU.union(v, u);
        }

        for(int i=0;i < C.size();i++){
            int u = C.get(i).get(0);
            int v = C.get(i).get(1);
            // if common nodes in B and C, return false
            if(typeOfppl.contains(u) || typeOfppl.contains(v)){
                return 0;
            }
            //else keep adding u-.v pairs of C into DSU
            DSU.union(v, u);
        }

        int sameGroupCount = 0;
        for(int i=1;i <= A;i++){
            //checking all nodes from 1 to A
            //and if parent of i == i i.e a group or set
            // (DSU concept of checking if the have common root parent, they belong to same set)
            if(DSU.root(i) == i){
                //same group count ++
                sameGroupCount++;
            }
        }

        int ans = 1;
        int mod = 1000000007;
        // as ways to suggest 2 diets to ppl in same group, it is  2^count of same group ppl
        //for minimizing complexity we are looping and moding till sameGroupCount,
        // else just (2^count of same group ppl) is the answer of wayd of suggestion
        for(int i=0;i < sameGroupCount;i++){
            ans*=2;
            ans%=mod;
        }

        return ans;
    }
}
