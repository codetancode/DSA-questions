//Distance between Nodes of BST
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
    int findDistanceInBST(TreeNode root,int B, int C){
        if(root==null){return 0;}
        // deciding based on comparision in BST
        if(root.val < B && root.val < C){
            return findDistanceInBST(root.right, B, C);
        }
        if(root.val > B && root.val > C){
            return findDistanceInBST(root.left, B, C);
        }

        //now root will be existing b/w B and c or, root is a common parent of B and C
        //sum of distance from root to B + root to C, as edge so no +1 in sum
        return calDistFromCommonParant(root, B) + calDistFromCommonParant(root, C);
    }

    int calDistFromCommonParant(TreeNode root,int target){
        if(root==null || root.val == target ){return 0;}

        //as BST
        if(root.val > target){
            return 1 + calDistFromCommonParant(root.left, target);
        }
        // anyway got right
        return 1 + calDistFromCommonParant(root.right, target);
    }

    public int solve(TreeNode A, int B, int C) {
        int res = 0;
        if(B > C){
            //send B as small val
            res = findDistanceInBST(A, C, B);
        }else{
            res = findDistanceInBST(A, B, C);
        }
        return res;
    }
}
