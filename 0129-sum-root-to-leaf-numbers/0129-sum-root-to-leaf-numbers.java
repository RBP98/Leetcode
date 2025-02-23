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
 
class Pair{
    TreeNode node;
    Integer curr;
    public Pair(TreeNode node, Integer curr){
        this.node = node;
        this.curr = curr;
    }
}
class Solution {
    public int sumNumbers(TreeNode root) {
        Deque<Pair> stack = new ArrayDeque<>();
        stack.push(new Pair(root, 0));
        int sum = 0;
        while(!stack.isEmpty()){
            Pair p = stack.pop();
            TreeNode key = p.node;
            int value = p.curr;
            if(key != null){
                value = value * 10 + key.val;
                if(key.left == null && key.right == null){
                    sum = sum + value;
                }
                stack.push(new Pair(key.right, value));
                stack.push(new Pair(key.left, value));
            }
            
        }

        return sum;
    }
}