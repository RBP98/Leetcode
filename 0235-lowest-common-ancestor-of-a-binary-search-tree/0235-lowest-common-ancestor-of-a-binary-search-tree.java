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
        if(root == null || p == root || q == root) return root;
        TreeNode lcaLeft = lowestCommonAncestor(root.left, p ,q);
        TreeNode lcaRight = lowestCommonAncestor(root.right, p ,q);
        if(lcaLeft == null) return lcaRight;
        else if(lcaRight == null) return lcaLeft;
        else return root;
    }
}