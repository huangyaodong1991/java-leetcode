package medium;

import basements.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        traversalRecursive(root, result);
        return result;
    }

    /**
     * 递归方式
     * @param treeNode
     * @param result
     */
    void traversalRecursive(TreeNode treeNode, List<Integer> result){
        if (treeNode == null){
            return;
        }

        traversalRecursive(treeNode.left, result);
        result.add(treeNode.val);
        traversalRecursive(treeNode.right, result);
    }

    /**
     * 非递归方式
     * @param root
     * @param result
     */
    void traversalNonRecursive(TreeNode root, List<Integer> result){
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pre;
        while (!stack.isEmpty()){
            //找左节点
            root = root.left;
            if (root != null){
                stack.push(root);
                continue;
            }
            root = stack.pop();
            //遍历中节点
            result.add(root.val);
            //找右节点
            while (root.right == null && !stack.isEmpty()){
                root = stack.pop();
                result.add(root.val);
            }

            root = root.right;
            if (root.right == null){
                break;
            }
            stack.push(root);
        }

    }

}
