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

    static boolean isPresent(TreeNode root, int target){
        if(root==null){
            return false;
        }
        //if found keep returning true
        if(root.val == target){
            return true;
        }

        //check if present in left or right subtree
        return isPresent(root.left, target) || isPresent(root.right, target);
    }

    // LCA By Returning NOT Null Values from both sides back to parent, and when parent get both not null return, that node is ancestor
    TreeNode LCAByReturn(TreeNode root, int B, int C){
        if(root==null){return null;}
        //id either b or c found return that node itself so not goinf deep down
        if(root.val==B || root.val == C){
            return root;
        }

        TreeNode left = LCAByReturn(root.left, B, C);
        TreeNode right = LCAByReturn(root.right, B, C);

        if(left!=null && right!=null){
            //if both are not null keep returning that root
            return root;
        }

        // else if left is not null return left, else right
        return left!=null?left:right;
    }
    public int lca(TreeNode A, int B, int C) {

        // first checking if both targets are present or not,
        if(isPresent(A, B) && isPresent(A, C)){
            TreeNode parent = LCAByReturn(A, B, C);
            return parent.val;
        }else{
            return -1;
        }
    }
}
