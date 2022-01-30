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
    //creating a class for tree nodes+loc
    class TreeNodeLoc{
        TreeNode node;
        int loc;
        TreeNodeLoc(TreeNode node, int loc){
            this.node = node;
            this.loc = loc;
        }
    }
    // idea is to do lvl traversal keeping track of left and righ loc, store in a Map(loc->list of nodes vals)
    //queue and curr will be of TreeNodeLoc type
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    HashMap<Integer, ArrayList<Integer>> locToNodes = new HashMap<>();
    Queue<TreeNodeLoc> lvlQ = new LinkedList<>();
    TreeNodeLoc curr;
    int leftMostLoc = 0;
    int rightMostLoc = 0;
    //lvl orders traversal by lvl size variable
    int lvlsize;

    // adding root in q and updating map
    lvlQ.add(new TreeNodeLoc(A, 0));
    locToNodes.put(0, new ArrayList<Integer>());
    locToNodes.get(0).add(A.val);

    while(!lvlQ.isEmpty()){
        lvlsize = lvlQ.size();

        //going for one leve nodes
        while(lvlsize > 0){
            curr = lvlQ.poll();
            //storing left and right in q and map updating most of left and right loc
            if(curr.node.left!=null){
                lvlQ.add(new TreeNodeLoc(curr.node.left, curr.loc-1));
                //map
                if(!locToNodes.containsKey(curr.loc-1)){
                    locToNodes.put(curr.loc-1, new ArrayList<Integer>());
                    locToNodes.get(curr.loc-1).add(curr.node.left.val);
                }else{
                    locToNodes.get(curr.loc-1).add(curr.node.left.val);
                }
                // as node at left add to curr.loc-1 update left most loc
                leftMostLoc = Math.min(leftMostLoc, curr.loc-1);
            }
            //same for right node
            if(curr.node.right!=null){
                lvlQ.add(new TreeNodeLoc(curr.node.right, curr.loc+1));
                //map
                if(!locToNodes.containsKey(curr.loc+1)){
                    locToNodes.put(curr.loc+1, new ArrayList<Integer>());
                    locToNodes.get(curr.loc+1).add(curr.node.right.val);
                }else{
                    locToNodes.get(curr.loc+1).add(curr.node.right.val);
                }
                // as node at right add to curr.loc+1 update right most loc
                rightMostLoc = Math.max(rightMostLoc, curr.loc+1);
            }
            lvlsize--;
        }
        //one lvl complete
    }
    //as we have loc and list of nodes VAL at that loc from leftmost to right most add in res
    //just appending list to res from map(loc->list of node values)
    for(int i=leftMostLoc;i <= rightMostLoc;i++){
        res.add(locToNodes.get(i));
    }
    return res;
    }
}
