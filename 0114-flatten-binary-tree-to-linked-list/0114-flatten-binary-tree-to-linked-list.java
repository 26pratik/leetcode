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
    public void flatten(TreeNode root) {
        helper(root);
    }
    private void helper(TreeNode root) {
        //base
        if(root == null) return;
        //logic
        helper(root.left);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        helper(temp);
        TreeNode temp2 = root;
        while(temp2.right != null) {
            temp2 = temp2.right;
        }
        temp2.right = temp;
    }
}