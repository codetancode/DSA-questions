/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    //iteratively joining left sub tree from root to right subtree in appropriate place, the continue to right and if left found add then in right
	public TreeNode flatten(TreeNode A) {
        TreeNode mainRoot = A;
        while(mainRoot!=null){
            if(mainRoot.left!=null){
                // going to 2->4, making it 2->4->5->6                  1
                                                                    //    \
                // now making 1 ka left as null and right as 2(subtree  3<-(2)->4->5->6)
        // if main root has left going left and then right most of it from root
        // adding mainRoot right after it, now making mainRoot=right as left
        // then again calling from 2 as mainroot 
                TreeNode trav = mainRoot.left;
                
                while(trav.right!=null){
                    trav=trav.right;
                }
                trav.right = mainRoot.right;
                mainRoot.right = mainRoot.left;
                mainRoot.left = null;
            }
            mainRoot = mainRoot.right; 
        }
        return A;

    }
}
