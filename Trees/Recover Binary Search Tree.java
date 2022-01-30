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
    //inorder of BST is sorted, lets do by that then think of constant space solution
    // O(n, n),bruteforce
    // could be better traversal using Morrise traversal will reduce recursive call stack space
    // int firstMax = 0;
    // int nextSmall = 0;
    ArrayList<Integer> inOTrav;
    void inOCheck(TreeNode head){
        if(head == null){return;}
        inOCheck(head.left);
        inOTrav.add(head.val);
        inOCheck(head.right);

    }
    public ArrayList<Integer> recoverTree(TreeNode A) {
        // firstMax = 0;
        // nextSmall = 0;
        ArrayList<Integer> res = new ArrayList<Integer>();
        inOTrav = new ArrayList<Integer>();
        inOCheck(A);
        res.add(0);
        res.add(0);

        // for(int i : inOTrav){System.out.print(i+" ,");}
        for(int i=1;i < inOTrav.size();i++){
            if(inOTrav.get(i) < inOTrav.get(i-1) && res.get(0) == 0){
                // increasing point detecting at i-1 (1st time)
                res.set(1, inOTrav.get(i-1));
            }
            if(inOTrav.get(i) < inOTrav.get(i-1)){
                // decreasing point detection at i(last time)
                res.set(0, inOTrav.get(i));
            }

        }
        return res;
    }
}
