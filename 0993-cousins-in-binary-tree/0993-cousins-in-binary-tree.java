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
    public boolean isCousins(TreeNode root, int x, int y) {
        
        this.x = x;
        this.y = y;
        this.xLevel = -1;
        this.yLevel = -2;
        
        helper(root, 0, null);
        
        return xLevel == yLevel;
    }
    
    private void helper(TreeNode root, int level, TreeNode parent) {
        
        if(root == null) return;
        
        if(root.left != null && root.right != null) {
            if(root.left.val == x && root.right.val == y) return;
            if(root.left.val == y && root.right.val == x) return;
        }

        if(root.val == x)
            xLevel = level;
        
        if(root.val == y)
            yLevel = level;
        
        helper(root.left, level+1, root);
        helper(root.right, level+1, root);
    }
}