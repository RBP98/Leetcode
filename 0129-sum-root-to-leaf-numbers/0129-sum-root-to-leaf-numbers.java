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
    int totalSum = 0;
    public int sumNumbers(TreeNode root) {
        
        preorder(root, 0);
        return totalSum;
    }
    private void preorder(TreeNode root, int curr){
        if(root != null){
            curr = curr * 10 + root.val;
            if(root.left == null && root.right == null){
                totalSum = totalSum + curr;
            }
            preorder(root.left, curr);
            preorder(root.right, curr);
        }
    }
}