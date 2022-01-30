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
    // O(n, h)
    static int count = 0;
    static void preO(TreeNode root,int B, int C){
        if(root==null){return;}
        if(root.val >= B && root.val <= C){
            count++;
        }
        preO(root.left, B, C);
        preO(root.right, B, C);
    }
    public int solve(TreeNode A, int B, int C) {
        // do a simple pre order trav, keeping a counter variable
        count=0;
        preO(A, B, C);
        return count;
    }
}
