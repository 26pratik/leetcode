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
//TC: O(n)
//SC: O(log n)
//DFS
class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        helper(root, 0);
        
        return result;
    }
    
    private void helper(TreeNode root, int depth) {
        
        if(root == null) return;
        
        if(result.size() == depth) 
            result.add(new ArrayList<>());
        result.get(depth).add(root.val);
        
        helper(root.left, depth+1);
        helper(root.right, depth+1);
    }
}