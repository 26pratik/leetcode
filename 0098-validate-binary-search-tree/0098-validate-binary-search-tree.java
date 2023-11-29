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
    
    public boolean isValidBST(TreeNode root) {
        
        return validate(root, new TreeNode[1]);
    }
    
    private boolean validate(TreeNode root, TreeNode[] prev) {
        
        if(root == null ) return true;
        
        if(!validate(root.left, prev)) return false;
        
        if(prev[0] != null && prev[0].val >= root.val) 
            return false;     
        prev[0] = root;
        
        return validate(root.right, prev);
    }
}