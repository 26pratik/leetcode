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
    
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        map = new HashMap<>();
        
        for(int i=0; i<inorder.length; i++)
            map.put(inorder[i], i);
        
        return helper(preorder, inorder);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder) {

        if(preorder.length == 0) return null;  
        
        int rootValue = preorder[0];
        int rIdx = map.get(rootValue);
        
        int[] inLeft = Arrays.copyOfRange(inorder, 0, rIdx);
        int[] inRight = Arrays.copyOfRange(inorder, rIdx+1, inorder.length);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, 1+inLeft.length);
        int[] preRight = Arrays.copyOfRange(preorder, 1+inLeft.length, preorder.length);
        
        TreeNode root = new TreeNode(rootValue);
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        
        return root;        
    }
}