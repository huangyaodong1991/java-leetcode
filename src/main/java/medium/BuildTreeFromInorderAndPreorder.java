package medium;

import basements.TreeNode;

public class BuildTreeFromInorderAndPreorder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }

    TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] preorder, int preStart, int preEnd){
        if (inStart == inEnd){
            return new TreeNode(inorder[inStart]);
        }

        if (inStart > inEnd){
            return null;
        }

        for (int i = preStart; i <= preEnd; i++){
            int val = preorder[i];
            for (int j = inStart; j <= inEnd; j++){
                if (val == inorder[j]){
                    TreeNode t = new TreeNode(val);
                    t.left = buildTree(inorder, inStart, j-1, preorder, i+1, preEnd);
                    t.right = buildTree(inorder, j+1, inEnd, preorder, i+1, preEnd);
                    return t;
                }
            }
        }

        return null;
    }
}
