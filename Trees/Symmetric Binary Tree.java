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
    static int isSym(TreeNode root1, TreeNode root2){
        // if both subtree are null true
        if(root1==null && root2==null){return 1;}

        // now if either of them are null return false
        if(root1==null || root2==null){return 0;}

        // if values doont match
        if(root1.val != root2.val){return 0;}

        // as mirror, check left with right, and right with left, for the subtrees
        return isSym(root1.left, root2.right) & isSym(root1.right, root2.left);
    }
    public int isSymmetric(TreeNode A) {
        // throw left and right root and recursivly check thir left and right
        return isSym(A.left, A.right);
    }
}
