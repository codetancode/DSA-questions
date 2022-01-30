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
    static class Pair{
        int sumTillNow;
        boolean isSumT;
        Pair(int sum, boolean isSumT){
            this.sumTillNow = sum;
            this.isSumT=isSumT;
        }
    }


    //Using pair and not recalculating sum again and again O(n, n)
    static Pair sumCheck(TreeNode root){
        // if leaf node or null valid so return 1
        if(root == null){return new Pair(0, true);}
        if(root.left==null && root.right == null){return new Pair(root.val, true);}

        Pair left = sumCheck(root.left);
        Pair right = sumCheck(root.right);

        //if sum == to current root and leftsubtree and right subtree are true(isSum binary)
        if(root.val == left.sumTillNow+right.sumTillNow && left.isSumT && right.isSumT){
            return new Pair(root.val+left.sumTillNow+right.sumTillNow, true);
        }

        // if not returned true earlier return false
        return new Pair(root.val+left.sumTillNow+right.sumTillNow, false);
    }

    public int solve(TreeNode A) {
        Pair lastReturn = sumCheck(A);
        return lastReturn.isSumT?1:0;
    }
}
