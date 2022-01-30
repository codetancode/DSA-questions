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
    //O(max(m,n), max(n,m))
    // with O(n) keeping space of set as max(n, m)
    // with O(m) checking if common then sum.

    static int sum = 0;
    static int mod=1000000007;
    //considering node values are distinct
    //putting nodes into set using preO and check with nodes at B(O(n, n))
    void addNodesToSet(TreeNode root, HashSet<Integer> set){
        if(root==null){return;}
        set.add(root.val);
        addNodesToSet(root.left, set);
        addNodesToSet(root.right, set);
    }
    void checkNodes(TreeNode root, HashSet<Integer> set){
        if(root==null){return;}
        if(set.contains(root.val)){
            sum=(sum + root.val)%mod;
        }
        checkNodes(root.left, set);
        checkNodes(root.right, set);
    }
    public int solve(TreeNode A, TreeNode B) {
        sum=0;//reset static variables
        HashSet<Integer> nodeInA = new HashSet<>();
        addNodesToSet(A, nodeInA);
        checkNodes(B, nodeInA);
        return sum;
    }
}
