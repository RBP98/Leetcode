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
    private void helper(TreeNode node, List<Integer> result, int level){
        if(node == null) return;
        if(level == result.size()){
            result.add(node.val);
        }

        helper(node.right, result, level + 1);
        helper(node.left, result, level + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        helper(root, result, 0);
        return result;
    }
}