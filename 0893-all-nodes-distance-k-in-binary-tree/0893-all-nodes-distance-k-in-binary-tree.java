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

        List<Integer> output = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        dfs(set, target, k, output);
        return output;
    }

    private void dfs(Set<Integer> set, TreeNode curr, int k, List<Integer> output){
        if(curr == null || set.contains(curr.val)) return;

            
            set.add(curr.val);
            if(k == 0){
                output.add(curr.val);
                return;
            }
        dfs(set, curr.left, k - 1, output);
        dfs(set, curr.right, k - 1, output);
        dfs(set, parentMap.get(curr), k - 1, output);


    }

    private void addParent(TreeNode curr, TreeNode parent){
        if(curr == null) return;

        parentMap.put(curr, parent);
        addParent(curr.left, curr);
        addParent(curr.right, curr);

    }
}