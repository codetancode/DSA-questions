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
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        //Dq for levels storage and peeking from both ends
        //last Node for picking last to identify currt reached level end
        //curr just to traverse the nodes
        Deque<TreeNode> lvlQ = new ArrayDeque<>();
        TreeNode lastNode=A;
        TreeNode curr;
        lvlQ.add(A);
        while(!lvlQ.isEmpty()){
            curr = lvlQ.poll();
            //adding right first in the q so that last of q will have left most node and we keep removing right nodes
            if(curr.right!=null){
                lvlQ.add(curr.right);
            }
            if(curr.left!=null){
                lvlQ.add(curr.left);
            }
            // if curr reaches last nod of levl, update ans and last node of modefied q
            if(curr == lastNode){
                res.add(curr.val);
                // last added node left node
                lastNode = lvlQ.peekLast();
            }

        }

        return res;
    }
}
