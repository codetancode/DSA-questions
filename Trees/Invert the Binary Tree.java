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
    // recursivly swaping the left and right nodes
    TreeNode invert(TreeNode root){
        if(root == null){return null;}

        // left subtree at temp,
        TreeNode temp = root.left;
        // root.left= invertcall on right
        root.left = invert(root.right);
        // root.right = invert call on previously stored temp subtree
        root.right = invert(temp);

        return root;
    }
    public TreeNode invertTree(TreeNode A) {
        return invert(A);
    }
}
