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
    
    List<List<Integer>> result;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        this.result = new ArrayList<>();
        
        helper(root, targetSum, 0, new ArrayList<>());
        
        return result;
    }
    
    private void helper(TreeNode root, int targetSum, int sum, List<Integer> path) {
        
        if(root == null) return;
        
        List<Integer> path1 = new ArrayList<>(path);
        
        sum += root.val;
        path1.add(root.val);  
        
        if(root.left == null && root.right == null) {
            if(sum == targetSum)
                result.add(path1);
            return;
        }
        
        helper(root.left, targetSum, sum, path1);
        helper(root.right, targetSum, sum, path1);
    }
}