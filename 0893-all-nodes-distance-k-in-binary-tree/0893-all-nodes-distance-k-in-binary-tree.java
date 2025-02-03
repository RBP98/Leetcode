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
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parentMap = new HashMap<>();
        addParent(root, null);

        Set<TreeNode> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();
      
        dfs(target, k, visited, result); 
        return result;
    }

    private void addParent(TreeNode child, TreeNode parent){
        if(child != null){
            parentMap.put(child, parent);
            addParent(child.left, child);
            addParent(child.right, child);
        }
    }

    private void dfs(TreeNode node, int distance, Set<TreeNode> visited, List<Integer> result){
        if(node == null || visited.contains(node)){
            return;
        }
        visited.add(node);
        if(distance == 0){
            result.add(node.val);
            return;
        }

        dfs(parentMap.get(node), distance - 1, visited, result);
        dfs(node.left, distance - 1, visited, result);
        dfs(node.right, distance - 1, visited, result);
    }
}