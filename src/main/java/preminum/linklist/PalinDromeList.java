package preminum.linklist;

import basements.ListNode;

public class PalinDromeList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }

        //计算长度
        int n = 0;
        for (ListNode p = head; p != null; p=p.next){
            n++;
        }

        //将链表拆成两个
        ListNode p = head;
        for (int i = 0; i < n/2-1; i++){
            p = p.next;
        }

        ListNode head2 = p.next;
        p.next = null;
        //忽略中间的节点
        if (n % 2 != 0){
            head2 = head2.next;
        }

        //翻转链表2
        ListNode preh2 = new ListNode(-1);
        while (head2 != null){
            ListNode pn = preh2.next;
            preh2.next = head2;
            ListNode hn = head2.next;
            head2.next = pn;
            head2 = hn;
        }
        head2 = preh2.next;

        for (;head != null && head2 != null;head = head.next, head2 = head2.next) {
            if (head.val != head2.val) {
                return false;
            }
        }
        return true;
    }
}
