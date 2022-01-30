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
    //this is  O(n2, n) approach, need O(n, n) using pair and not recalculating sum again and again
    static int sumCheck(TreeNode root){
        // if leaf node or null valid so return 1
        if(root == null){return 1;}
        if(root.left==null && root.right == null){return 1;}

        // get left and right sum
        int left = sum(root.left);
        int right = sum(root.right);

        // if left and right sum == current root
        int temp = (left+right == root.val)?1:0;

        // if left and right sum == current root && left subtree and right subtree are also having sum == root val, then return 1
        if( ( temp & sumCheck(root.left)  & sumCheck(root.right) ) == 1 ){
            return 1;
        }
        //if not previously true return 0
        return 0;
    }

    // for getting left subtree sum and right subtree sum
    static int sum(TreeNode root){
        if(root==null){return 0;}
        return root.val+sum(root.left)+sum(root.right);
    }

    public int solve(TreeNode A) {
        return sumCheck(A);
    }
}
