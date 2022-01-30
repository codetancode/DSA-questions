/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
   //O(n, max(lvlNodes))
    public void connect(TreeLinkNode root) {
        //level order trav and in a level curr is not the last node connect with next with other nodes
        //lvl Order using lastNode reference, if last curr.next=null, else joining curr.next=lvl.peek()
        Deque<TreeLinkNode> lvlNodes = new ArrayDeque<>();
        TreeLinkNode lastNode = root;
        TreeLinkNode curr;
        lvlNodes.add(root);
        while(!lvlNodes.isEmpty()){
            curr = lvlNodes.poll();
            if(curr.left!=null){
                lvlNodes.add(curr.left);
            }
            if(curr.right!=null){
                lvlNodes.add(curr.right);
            }

            if(curr == lastNode){
                //as one level is ended last node of lvl should point to null,
                // updating next last node of level
                curr.next = null;
                lastNode = lvlNodes.peekLast();
            }else{
                //joining next node to queue peek node
                curr.next=lvlNodes.peek();
            }
        }
    }
}
