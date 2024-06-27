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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
            return list;
        queue.add(root);
        boolean flag = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tempList = new LinkedList<>();
            for(int i = 0; i < size; i++){
                TreeNode temp = queue.poll();
                if(flag){
                    tempList.addFirst(temp.val);
                }else{
                    tempList.addLast(temp.val);
                }
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
                

            }
            flag = !flag;
            list.add(tempList);
        }
        return list;
    }
}