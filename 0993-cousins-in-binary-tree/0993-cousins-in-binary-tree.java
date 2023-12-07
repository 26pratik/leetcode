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
    
    int x;
    int y;
    int xLevel;
    int yLevel;
    TreeNode xParent;
    TreeNode yParent;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        
        this.x = x;
        this.y = y;
        this.xLevel = -1;
        this.yLevel = -1;
        this.xParent = null;
        this.yParent = null;
        
        helper(root, 0, null);
        
        return xLevel == yLevel && xParent != yParent;
    }
    
    private void helper(TreeNode root, int level, TreeNode parent) {
        
        if(root == null) return;
        if(xLevel != -1 && yLevel != -1) return;

        if(root.val == x) {
            xLevel = level;
            xParent = parent;    
        }
        
        if(root.val == y) {
            yLevel = level;
            yParent = parent;    
        }
        
        helper(root.left, level+1, root);
        helper(root.right, level+1, root);
    }
}