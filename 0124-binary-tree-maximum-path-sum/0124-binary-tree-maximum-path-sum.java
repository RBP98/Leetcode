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
    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        helper(root, maxSum);
        return maxSum[0];
    }

    private int helper(TreeNode node, int[] maxSum){
        if(node == null)
            return 0;
        int leftSum = 0;
        int rightSum = 0;
        leftSum = Math.max(0, helper(node.left, maxSum));
        rightSum = Math.max(0, helper(node.right, maxSum));
        maxSum[0] = Math.max(maxSum[0], leftSum + rightSum + node.val);
        return node.val + Math.max(leftSum, rightSum);
    }
}