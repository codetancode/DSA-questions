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
    // idea is finding root from post array and find it in InO array either using MAP, or simple traversal, or global index variable

    // this can be solved using 3 methods for keeping track of root index in inorders array
    //1st simple traversal from left <=rightSub index and in case of Pre orders, root.right->post = rootPositionPostO-1, root.right=  rootPositionPostO - (rightSubInO - rootIndexinInO) - 1
    //keep a map of indexes of InO, finding root will become easy,rootindexINO=map.get(rootVal) then root.right->->post = rootPositionPostO-1, right= rootPositionPostO - (rightSubInO - rootIndexinInO) - 1

    // given inorder leftSubTree Node RightSubtree
    // given postorder leftSubTree RightSubtree Node
    static HashMap<Integer, Integer> valToIndexInO = new HashMap<>();
    static int postIndex = 0;
    // will call a recursive function witha new node in each funRecursiveCall
    // for start we are sure postO will have root at the end and inO will have roots left and right sub tree nodes
    // 2 pointer for In orders array, to keep track till left sub tree and rightSubtree, root position if for Post Order array
    TreeNode recFromTrav(ArrayList<Integer> InO, ArrayList<Integer> PostO, int leftSubInO, int rightSubInO, int rootPositionPostO){
        // breaking conditions, if no nodes, of just 1 node
        if(leftSubInO > rightSubInO){return null;}
        // now making root from last of post
        int rootval = PostO.get(rootPositionPostO);
        TreeNode root = new TreeNode(rootval);

        // finding root from post array and find it in InO array either using MAP, or simple traversal
        // int rootIndexinInO = InO.get(postIndex);
        int rootIndexinInO = valToIndexInO.get(rootval);
        //find root val index in InO via traversing from left to right in InO array
        // for(int i=leftSubInO;i <= rightSubInO;i++){
        //     if(InO.get(i) == rootval){
        //         rootIndexinInO = i;
        //         break;
        //     }
        // }
        // it will always run as root must lie b/w leftSub and right Sub in InO array
        // now construct left and right subtree of root recursively
        // for left sub tree rootIndex in PostO will be (last rootPositionPostO-#nodes in rightBubtree - 1)->(rootPositionPostO - (rightSubInO - rootIndexinInO) - 1)
        // for right sub tree rootIndex in PostO will be just last rootIndex - 1
        //using post will automatically be handled as recursive calls
        postIndex--;
        // root.left = recFromTrav(InO, PostO, leftSubInO, rootIndexinInO - 1, rootPositionPostO - (rightSubInO - rootIndexinInO) - 1);
        root.right = recFromTrav(InO, PostO, rootIndexinInO + 1, rightSubInO, postIndex);
        root.left = recFromTrav(InO, PostO, leftSubInO, rootIndexinInO - 1, postIndex);

        return root;
    }
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        //a is inorder, b is post
        //idea is to have 1 pointer in post Array, and 2 in inorders,
        // finding root from post array and find it in InO array either using MAP, or simple traversal
        TreeNode root;
        //gloabal map so clear in main
        postIndex = B.size()-1;
        valToIndexInO.clear();
        // storing inorder values and index in map
        for(int i=0;i < A.size();i++){
            valToIndexInO.put(A.get(i), i);
        }
        root = recFromTrav(A, B, 0, A.size()-1, postIndex);
        return root;
    }
}
