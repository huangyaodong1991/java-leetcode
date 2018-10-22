package preminum.linklist;

import basements.ListNode;

public class ReverseLinkList {
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return head;
        }

        ListNode preHead = new ListNode(-1);
        ListNode p,pp;

        for (;head != null;){
            p = preHead.next;
            preHead.next = head;
            pp = head.next;
            head.next = p;
            head = pp;
        }

        return preHead.next;
    }
}
