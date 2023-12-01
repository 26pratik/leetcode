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
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(postorder.length == 0) return null;
        
        int iLen = inorder.length, pLen = postorder.length;
        int rootValue = postorder[pLen-1];
        int rIdx = -1;
        
        for(int i=0; i<iLen; i++)
            if(inorder[i] == rootValue)
                rIdx = i;

        int[] inLeft = Arrays.copyOfRange(inorder, 0, rIdx);
        int[] inRight = Arrays.copyOfRange(inorder, rIdx+1, iLen);
        int[] postLeft = Arrays.copyOfRange(postorder, 0, inLeft.length);
        int[] postRight = Arrays.copyOfRange(postorder, inLeft.length, pLen-1);

        TreeNode root = new TreeNode(rootValue);
        root.right = buildTree(inRight, postRight);
        root.left = buildTree(inLeft, postLeft);

        return root;
    }
}