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
// O(n, n) solution
public class Solution {
    int pathSum0Ornot(TreeNode root, int sum){
        if(root==null){return 0;}
        //reduce sum for this function call and check if root is the leaft node then return
        sum-=root.val;
        if(root.left==null && root.right==null){
            return sum==0?1:0;
        }
        return pathSum0Ornot(root.left, sum) | pathSum0Ornot(root.right, sum);
    }
    public int hasPathSum(TreeNode A, int B) {
        return pathSum0Ornot(A, B);
    }
}
