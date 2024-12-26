/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        // if((p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val)){
        //     return root;
        // }
        

         int rootVal = root.val;
        if(rootVal < p.val && rootVal < q.val)
            return lowestCommonAncestor(root.right, p, q);

        else if(rootVal > p.val && rootVal > q.val)
            return lowestCommonAncestor(root.left, p, q);
        else
            return root;
        
    }
}