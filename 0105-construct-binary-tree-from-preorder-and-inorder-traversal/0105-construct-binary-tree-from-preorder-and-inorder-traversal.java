class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length == 0) return null;
        
        int rootValue = preorder[0];
        int rIdx = -1;
        for(int i=0; i<inorder.length; i++)
            if(inorder[i] == rootValue)
                rIdx = i;

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