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
    // given inorder leftSubTree Node RightSubtree
    // given postorder leftSubTree RightSubtree Node

    // will call a recursive function witha new node in each funRecursiveCall
    // for start we are sure postO will have root at the end and inO will have roots left and right sub tree nodes
    // 2 pointer for In orders array, to keep track till left sub tree and rightSubtree, root position if for Post Order array
    TreeNode recFromTrav(ArrayList<Integer> InO, ArrayList<Integer> PostO, int leftSubInO, int rightSubInO, int rootPositionPostO){
        // breaking conditions, if no nodes, of just 1 node
        if(leftSubInO > rightSubInO){return null;}
        if(leftSubInO == rightSubInO){return new TreeNode(InO.get(leftSubInO));}

        // now making root from last of post
        int rootval = PostO.get(rootPositionPostO);
        TreeNode root = new TreeNode(rootval);

        int rootIndexinInO = leftSubInO;
        //find root val index in InO via traversing from left to right in InO array
        for(int i=leftSubInO;i <= rightSubInO;i++){
            if(InO.get(i) == rootval){
                rootIndexinInO = i;
                break;
            }
        }
        // it will always run as root must lie b/w leftSub and right Sub in InO array

        // now construct left and right subtree of root recursively
        // for left sub tree rootIndex in PostO will be (last rootPositionPostO-#nodes in rightBubtree - 1)
        // for right sub tree rootIndex in PostO will be just last rootIndex - 1

        root.left = recFromTrav(InO, PostO, leftSubInO, rootIndexinInO - 1, rootPositionPostO - (rightSubInO - rootIndexinInO) - 1);
        root.right = recFromTrav(InO, PostO, rootIndexinInO + 1, rightSubInO, rootPositionPostO - 1);

        return root;
    }
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        TreeNode root;
        root = recFromTrav(A, B, 0, A.size()-1, B.size()-1);
        return root;
    }
}
