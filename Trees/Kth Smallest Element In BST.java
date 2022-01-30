/**
 * Definition for binary tree
 * class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) {
             * val = x;
             * left = null;
             * right = null;
             *
         }
         *
 }
 */
 //going inorder and keeping count till k
 public class Solution {
     static int k = 0;

     public int kthsmallest(TreeNode A, int B) {
         //reinitialize gobal k for multiple test cases
         k = B;
         return find(A);
     }
     public static int find(TreeNode root) {
         if (root == null)
             return -1;
         // We do an inorder traversal here. so root.left func call
         int k1 = find(root.left);
         //if in left subtree we found k=0
         if (k == 0){
         // left subtree has k or more elements.
             return k1;
         }

         //reduce k for current node
         k--;
         //if k==0 we found our root val
         if (k == 0){
             return root.val; // root is the kth element.
         }
         //else going root.right as per inorders traversal
         return find(root.right); // answer lies in the right node.
     }
 }