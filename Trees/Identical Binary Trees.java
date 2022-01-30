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
    // O(n, n)
    static int isSame(TreeNode A, TreeNode B){
        // all possible null combinations
        if(A==null && B==null){return 1;}
        if(A==null && B!=null){return 0;}
        if(A!=null && B==null){return 0;}

        // if values dont match
        if(A.val != B.val ){
            return 0;
        }

        // returnning & of int returns of left and right side node
        return isSame(A.left, B.left) & isSame(A.right, B.right);

    }
    public int isSameTree(TreeNode A, TreeNode B) {
        return isSame(A, B);
    }
}
