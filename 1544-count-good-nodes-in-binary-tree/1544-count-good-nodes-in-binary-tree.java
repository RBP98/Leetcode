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
    int goodNodes = 0;
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        helper(root, Integer.MIN_VALUE);
        return goodNodes;
    }

    private void helper(TreeNode root, int maxSoFar){
        if(maxSoFar <= root.val){
            maxSoFar = root.val;
            goodNodes++;
        }

        if(root.right != null){
            helper(root.right, maxSoFar);
        }

        if(root.left != null){
            helper(root.left, maxSoFar);
        }
    }
}