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
    public List<Integer> largestValues(TreeNode root) {
        
        if(root == null) return new ArrayList<>();
        
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();
                
                if(result.size() == level) 
                    result.add(node.val);
                else
                    result.set(level, Math.max(node.val, result.get(level)));
                
                if(node.left != null) 
                    q.add(node.left);
                
                if(node.right != null)
                    q.add(node.right);
            }
            level++;
        }
        
        return result;
    }
}