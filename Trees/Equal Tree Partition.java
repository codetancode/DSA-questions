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
    //long for owerflows
    // storing intermedeate sum then matching if its halfSum
    static long totalSum = 0;
    static int halfSum = 0;
    static long checkSumE(TreeNode root){
        if(root == null){return 0;}
        // taking new intermedeate sum for the new root
        long intermSum = root.val + checkSumE(root.left) + checkSumE(root.right);
        if(intermSum == (totalSum/2)){
            halfSum = 1;
        }
        //returning current root sum for every call
        return intermSum;
    }

    public int solve(TreeNode A) {
        halfSum = 0;
        totalSum = checkSumE(A);
        checkSumE(A);
        return halfSum;
    }
}
