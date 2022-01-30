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
     //idea is to pick mid as root node and build tree accordingly
    static TreeNode buildFromMid(List<Integer> givenSorted, int leftSubT, int rightSubT){
        if(leftSubT > rightSubT){
            return null;
        }
        int midIndex = (leftSubT+rightSubT)>>1;
        TreeNode root = new TreeNode(givenSorted.get(midIndex));
        root.left = buildFromMid(givenSorted, leftSubT, midIndex-1);
        // AND RECURSIVE CALLS TO LEFT leftSubTbuildFromMid indexes
        root.right = buildFromMid(givenSorted, midIndex+1, rightSubT);
        // AND RECURSIVE CALLS TO right rightSubTbuildFromMid indexes

        // as after all recursion call 1st mid root will get returned
        return root;
    }
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public TreeNode sortedArrayToBST(final List<Integer> A) {
        return buildFromMid(A, 0, A.size()-1);
    }
}
