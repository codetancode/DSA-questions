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
    int checkIfBcomplement(TreeNode root, int B, HashSet<Integer> set){
        if(root==null){return 0;}
        // keep complements and check
        if(set.contains(B-root.val)){
            return 1;
        }else{
            set.add(root.val);
        }
        return checkIfBcomplement(root.left, B, set) | checkIfBcomplement(root.right, B, set);

    }
    public int t2Sum(TreeNode A, int B) {
        HashSet<Integer> set = new HashSet<>();
        return checkIfBcomplement(A, B, set);
    }
}
