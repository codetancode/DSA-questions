/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    class TreeNodeLoc{
        TreeNode node;
        int loc;
        TreeNodeLoc(TreeNode node, int loc){
            this.node = node;
            this.loc = loc;
        }
    }
    public ArrayList<Integer> solve(TreeNode A) {
        // do lvl order travesal and keep left most and right most node val into result
        // lvl order trav using size of lvl variable
        //a new class Treenode with loc to store in queue with their location, a map loc->list of nodes
        //2 variable to keep track of left and right maxLocations
        int leftMaxLoc = 0;
        int rightMaxLoc = 0;

        //for result
        ArrayList<Integer> res = new ArrayList<Integer>();
        HashMap<Integer, ArrayList<TreeNode>> locToNodelis = new HashMap<>();
        //queue and curr of type TreeNodeLoc coz it will have location with nodes
        TreeNodeLoc curr;
        Deque<TreeNodeLoc> lvlQ = new ArrayDeque<>();
        //lvl order trav with lvlsize variable
        int lvlsize;

        //storing root at location 0, in q and map(loc->list of nodes)
        lvlQ.add(new TreeNodeLoc(A, 0));
        locToNodelis.put(0, new ArrayList<TreeNode>());
        locToNodelis.get(0).add(A);

        while(!lvlQ.isEmpty()){
            lvlsize = lvlQ.size();

            while(lvlsize > 0){
                curr = lvlQ.poll();
                //just for storing all possible nodes in level
                // as curr will have node and loc
                if(curr.node.left!=null){
                    // have to create new TreeNodeLoc with updated loc,(left -1, and right +1) and store in Q and
                    // just store node in Map at right loc
                    //loc-1 for left in queue TreeNodeLoc
                    lvlQ.add(new TreeNodeLoc(curr.node.left, curr.loc-1));
                    if(!locToNodelis.containsKey(curr.loc-1)){
                        locToNodelis.put(curr.loc-1, new ArrayList<TreeNode>());
                        locToNodelis.get(curr.loc-1).add(curr.node.left);
                    }else{
                        locToNodelis.get(curr.loc-1).add(curr.node.left);
                    }
                    // update the keys left
                    leftMaxLoc = Math.min(leftMaxLoc, curr.loc-1);
                }

                // loc + 1 for right, in queue TreeNodeLoc
                if(curr.node.right!=null){
                    lvlQ.add(new TreeNodeLoc(curr.node.right, curr.loc+1));
                    if(!locToNodelis.containsKey(curr.loc+1)){
                        locToNodelis.put(curr.loc+1, new ArrayList<TreeNode>());
                        locToNodelis.get(curr.loc+1).add(curr.node.right);
                    }else{
                        locToNodelis.get(curr.loc+1).add(curr.node.right);
                    }
                    // update the keys right
                    rightMaxLoc = Math.max(rightMaxLoc, curr.loc+1);
                }
                lvlsize--;
            }
            //end of one level
        }

        // now just traversing through leftmostLoc to right Most loc picking 1st node
        for(int i=leftMaxLoc;i <= rightMaxLoc;i++){
            res.add(locToNodelis.get(i).get(0).val);
        }
        return res;

    }
}
