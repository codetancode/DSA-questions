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
    //idea is to store lvl order traversal in res, and then reverse odd index array for zig zag
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Deque<TreeNode> lvlQ = new ArrayDeque<>();
        int lvlNodeSize=0;
        TreeNode curr;
        lvlQ.add(A);

        while(!lvlQ.isEmpty()){
            //updating the size of lvl nodes
            lvlNodeSize = lvlQ.size();
            ArrayList<Integer> lvlNodes = new ArrayList<Integer>();

            while(lvlNodeSize > 0){
                // picking nodes from q(left) and adding left and then right into the queue
                curr = lvlQ.poll();
                if(curr.left!=null){
                    lvlQ.add(curr.left);
                }
                if(curr.right!=null){
                    lvlQ.add(curr.right);
                }
                //keep reducing the size of lvl nodes
                lvlNodes.add(curr.val);
                lvlNodeSize--;
            }
            //adding the lvl nodes list into res
            res.add(lvlNodes);

        }

        //reversing odd index list in res
        for(int i=0;i < res.size();i++){
            if(i%2==1){
                Collections.reverse(res.get(i));
            }
        }
        return res;
    }
}
