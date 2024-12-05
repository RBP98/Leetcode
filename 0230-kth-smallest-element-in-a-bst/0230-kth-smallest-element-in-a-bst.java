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
    int result = Integer.MIN_VALUE;
    int count = 0;

    private void kthSmallestHelper(TreeNode root,int k){
        if(root == null){
            return ;
        }

        kthSmallestHelper(root.left,k);
        
        count++;
        if(k == count){
            result = root.val;
        }

        kthSmallestHelper(root.right, k);

    }
    public int kthSmallest(TreeNode root, int k) {
        kthSmallestHelper(root, k);
        return result;
    }
}