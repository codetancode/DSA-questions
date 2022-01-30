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
    //bruteforce, store inorder travesal and return k-1 index
    static void inorderStore(TreeNode root, ArrayList<Integer> inO){
        if(root == null){return;}
        inorderStore(root.left, inO);
        inO.add(root.val);
        inorderStore(root.right, inO);

    }
    public int kthsmallest(TreeNode A, int B) {
        //InOrder of BST is always sorted
        // brute force
        ArrayList<Integer> inO = new ArrayList<>();
        inorderStore( A, inO);
        return inO.get(B-1);
    }
}
