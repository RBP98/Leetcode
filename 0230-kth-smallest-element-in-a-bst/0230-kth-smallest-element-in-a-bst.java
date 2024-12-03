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
    private int count = 0;
    private int output = Integer.MIN_VALUE;

    private void kthSmallestHelper(TreeNode root, int k){
        if(root == null) return ;

        kthSmallestHelper(root.left, k);

        count++;

        if(count == k){
            output = root.val;
            return;

        }
            
        kthSmallestHelper(root.right, k);

    } 

    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        kthSmallestHelper(root, k);
        return output;
    }
}