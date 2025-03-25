/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, TreeNode> parentMap;
    private void addParent(TreeNode node, TreeNode parent){
        if(node != null){
            parentMap.put(node, parent);
            addParent(node.left, node);
            addParent(node.right, node);
        }
    }

    private void dfs(int k, TreeNode node, List<Integer> list, Set<TreeNode> visited){
        if(node == null || visited.contains(node)){
            return;
        }
        visited.add(node);

        if(k == 0){
            list.add(node.val);
            return;
        }

        dfs(k - 1, node.left, list, visited);
        dfs(k - 1, node.right, list, visited);
        dfs(k - 1, parentMap.get(node), list, visited);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parentMap = new HashMap<>();
        addParent(root, null);

        List<Integer> list = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();

        dfs(k, target, list, visited);
        return list;
    }


}