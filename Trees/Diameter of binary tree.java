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
    // calculating left height and right height, +1+1 for current height
    static int diameter = 0;
    int height(TreeNode root){
        //leaf nodes will get -1 -1 from left and right and max height
        if(root==null){return -1;}
        int hl=height(root.left);
        int hr=height(root.right);
        // +1+1 for left and right node
        diameter = Math.max(diameter, (hl + hr)+1+1);

        //returning max of left height and right height and +1 for considering current node
        return Math.max(hl, hr)+1;

    }
    public int solve(TreeNode A) {
        diameter = 0;
        height(A);
        return diameter;
    }
}
