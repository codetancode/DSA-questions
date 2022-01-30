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
    public int solve(TreeNode A) {
        //tracking the levels by lvl size variables and a veriable for odd and even lvl
        int oddSum = 0;
        int evenSum = 0;
        boolean odd = true;
        Deque<TreeNode> lvlQ = new ArrayDeque<>();
        int lvlNodesize;
        TreeNode curr;
        lvlQ.add(A);

        while(!lvlQ.isEmpty()){
            lvlNodesize = lvlQ.size();
            // going into one level ill the lvl size reduced to 0
            while(lvlNodesize > 0){
                curr = lvlQ.poll();
                //into one level,
                //keep updating subsequent nodes in lvl q
                if(curr.left != null){
                    lvlQ.add(curr.left);
                }
                if(curr.right != null){
                    lvlQ.add(curr.right);
                }
                //now updating ans for this level
                if(odd){
                    oddSum+=curr.val;
                }else{
                    evenSum+=curr.val;
                }
                lvlNodesize--;
            }
            // after one level ends change odd to even
            odd = !odd;
        }

    return oddSum-evenSum;
    }
}
