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
    List<Integer> path;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        result = new ArrayList<>();
        path = new ArrayList<>();
        
        helper(root, targetSum, 0);
        
        return result;
    }
    
    private void helper(TreeNode root, int targetSum, int sum) {
        
        if(root == null) return;
        
        path.add(root.val);
        sum += root.val;
        
        if(root.left == null && root.right == null) {
            if(sum == targetSum)
                result.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }
        
        helper(root.left, targetSum, sum);
        helper(root.right, targetSum, sum);
        
        path.remove(path.size()-1);
    }
}