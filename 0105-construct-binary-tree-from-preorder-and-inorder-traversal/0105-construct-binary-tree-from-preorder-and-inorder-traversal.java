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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> preList = new ArrayList<>();
        for(int i: preorder){
            preList.add(i);
        }
        List<Integer> inList = new ArrayList<>();
        for(int i: inorder){
            inList.add(i);
        }

        return helper(preList, inList);
    }

    public TreeNode helper(List<Integer> preorder, List<Integer> inorder) {
        if(preorder.size() == 0 || inorder.size() == 0) return null;
        int rootVal = preorder.get(0);
        
        int rootIndex = inorder.indexOf(rootVal);
        List<Integer> leftInorder = inorder.subList(0, rootIndex);
        List<Integer> rightInorder = inorder.subList(rootIndex + 1, inorder.size());

        List<Integer> leftPreorder = preorder.subList(1, 1 + leftInorder.size());
        List<Integer> rightPreorder = preorder.subList(1 + leftInorder.size(), preorder.size());

        
        TreeNode rootNode = new TreeNode(rootVal);
        rootNode.left = helper(leftPreorder, leftInorder);
        rootNode.right = helper(rightPreorder, rightInorder);

        return rootNode;
    }

       
}