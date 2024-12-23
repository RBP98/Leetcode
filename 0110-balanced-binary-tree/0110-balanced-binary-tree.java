/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        if(Math.abs(checkHeight(root.left) - checkHeight(root.right)) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right); 
    }

    private int checkHeight(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(checkHeight(root.left), checkHeight(root.right));
    }

}