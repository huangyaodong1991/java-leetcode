package medium;

import basements.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ZigZagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelNodeCount = 1;
        int levelNum = 0;
        LinkedList<Integer> level = new LinkedList<>();

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            levelNodeCount--;

            addVal(level, node, levelNum);

            if (node.left != null){
                queue.offer(node.left);
            }

            if (node.right != null){
                queue.offer(node.right);
            }

            if (levelNodeCount == 0){
                levelNum++;
                result.add(level);
                levelNodeCount = queue.size();
                level = new LinkedList<>();
            }
        }

        //确保最后一层的数据不被漏掉
        if (level.size() != 0){
            result.add(level);
        }

        return result;
    }

    private void addVal(LinkedList<Integer> level, TreeNode treeNode, int levelNum){
        if (levelNum % 2 == 0){
            level.add(treeNode.val);
        }else{
            level.addFirst(treeNode.val);
        }
    }
}
