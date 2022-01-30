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
    static int maxSize = 1;
    // max possible and min possible range for root value to be BST, 
    // boolean isBst for checking all subtree
    // size varable for counting node
    static int[] isLargestBST(TreeNode root){   
        //in the array returning [ max, min, isBST, size] all int
        if(root==null){return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 1, 0}; }
        int[] lrange = isLargestBST(root.left);
        int[] rrange = isLargestBST(root.right);
            
        // if root val > left ka max and root val is < right ka min, also check if left and right both are bst
        if(root.val > lrange[0] && root.val < rrange[1] && lrange[2]==1 && rrange[2]==1){
            //current node + size of left and right
            int tempSize = 1 + lrange[3]+rrange[3];
            maxSize = Math.max(maxSize, tempSize);
            int[] range = {Math.max(root.val, rrange[0]), Math.min(root.val, lrange[1]), 1, tempSize};
            return range;
        
        }

        int[] range = {Math.max(root.val, rrange[0]), Math.min(root.val, lrange[1]), 0, 0};
        return range;
    }
    public int solve(TreeNode A) {
        //atleast will have have 1 node as BST
        maxSize=1;
        isLargestBST(A);
        return maxSize;
    }
}
