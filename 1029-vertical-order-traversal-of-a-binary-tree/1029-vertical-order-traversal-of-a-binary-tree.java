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
class Tuple{
    int level;
    int vertical;
    TreeNode node;
    public Tuple(int level, int vertical, TreeNode node){
        this.level = level;
        this.vertical = vertical;
        this.node = node;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<Integer, PriorityQueue<TreeNode>>> map = new TreeMap<>();
        Queue<Tuple> queue = new ArrayDeque<>();
        queue.add(new Tuple(0, 0, root));

        while(!queue.isEmpty()){
            Tuple t = queue.poll();
            int level = t.level;
            int vertical = t.vertical;
            TreeNode node = t.node;
            Map<Integer, PriorityQueue<TreeNode>> tempMap;    
            PriorityQueue<TreeNode> pq; 
            
            if(map.containsKey(vertical)){
                tempMap = map.get(vertical); 
            }else{
                tempMap = new TreeMap<>();
                map.put(vertical, tempMap);
            }

            if(tempMap.containsKey(level)){
                pq = tempMap.get(level);
            }else{
                pq = new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val));
                tempMap.put(level, pq);
            }

            pq.add(node);
            if(node.left != null){
                queue.add(new Tuple(level + 1, vertical - 1, node.left));
            }
            if(node.right != null){
                queue.add(new Tuple(level + 1, vertical + 1, node.right));
            }
                

        }
        List<List<Integer>> output = new ArrayList<>();
        for(Map<Integer, PriorityQueue<TreeNode>> temp: map.values()){
            List<Integer> list  = new ArrayList<>();
            for(PriorityQueue<TreeNode> pq: temp.values()){
                while(!pq.isEmpty()){
                    list.add(pq.poll().val);
                }
                
            }
            output.add(list);
        }
    return output;
    }
}