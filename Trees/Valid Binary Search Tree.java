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
    static boolean isBST = true;
    static int[] preOLRrangeCheck(TreeNode node){
        // [max, min] possible range for the root for valid bst
        // at root for always valid returning [int min, int max]
        if(node == null){return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};}

        int[] lrange = preOLRrangeCheck(node.left);
        int[] rrange = preOLRrangeCheck(node.right);

        //violating condition
        if(node.val <= lrange[0] || node.val >= rrange[1]){
            isBST = false;
        }

        int[] range = {Math.max(node.val, rrange[0]), Math.min(node.val, lrange[1])};
        return range;
    }

    public int isValidBST(TreeNode A) {
        //single node check
        if(A.left==null && A.right==null){return 1;}
        isBST = true;
        // boolean isBST = leftRightRangeCheck(A);
        preOLRrangeCheck(A);
        return (isBST)?1:0;
    }
}
