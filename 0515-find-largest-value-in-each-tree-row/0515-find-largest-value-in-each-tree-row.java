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
    
    List<Integer> result;
    
    public List<Integer> largestValues(TreeNode root) {
        
        if(root == null) return new ArrayList<>();
        
        this.result = new ArrayList<>();
        
        dfs(root, 0);
        
        return result;
    }
    
    private void dfs(TreeNode root, int level) {
        
        if(root == null) return;
        
        if(result.size() == level)
            result.add(root.val);
        else
            result.set(level, Math.max(root.val, result.get(level)));
        
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}