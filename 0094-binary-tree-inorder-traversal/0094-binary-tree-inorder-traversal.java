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
    public List<Integer> inorderTraversal(TreeNode root) {
        return inorder(root);
    }

    private List<Integer> inorder(TreeNode root){
        List<Integer> list = new ArrayList<Integer>();
        if(root == null) return list;
        
        list.addAll(inorder(root.left));
        list.add(root.val);
        list.addAll(inorder(root.right));

        return list;
    }
}