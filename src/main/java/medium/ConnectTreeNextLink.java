package medium;


public class ConnectTreeNextLink {
    public void connect(TreeLinkNode root) {
        if (root == null){
            return;
        }

        //先连接每个节点的左右子树
        connectLeftAndRight(root);

        //再将补完中间有缺失部分的连接
        TreeLinkNode preNode = root;
        TreeLinkNode head = root;
        TreeLinkNode oldHead = head;
        while (head != null){
            if (head.next == null) {
                if (preNode != null && preNode.next != null) {
                    //此处假设完全二叉树
                    head.next = preNode.next.left;
                    preNode = preNode.next;
                }else{
                    preNode = oldHead;
                    oldHead = oldHead.left;
                    head = oldHead;
                    continue;
                }
            }

            head = head.next;
        }

    }

    private void connectLeftAndRight(TreeLinkNode root){
        if (root == null){
            return;
        }

        if (root.left == null || root.right == null){
            return;
        }

        root.left.next = root.right;

        connectLeftAndRight(root.left);
        connectLeftAndRight(root.right);
    }

    private void connectDirectly(TreeLinkNode root){
        if (root == null){
            return;
        }

        if (root.left != null){
            root.left.next = root.right;
        }

        //此时上一层肯定已经连接完成了，故可以直接用已经构建的next指针
        if (root.right != null && root.next != null){
            root.right = root.next.left;
        }

        connectDirectly(root.left);
        connectDirectly(root.right);
    }

    private class TreeLinkNode{
        int val;
        TreeLinkNode left,right,next;
        TreeLinkNode(int val){
            this.val = val;
        }
    }
}
