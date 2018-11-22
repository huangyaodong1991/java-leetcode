package medium;

import basements.ListNode;

public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        int n = 0;
        ListNode h = head, p = head, f = head, tmp = null;
        while (head!= null){
            if (++n == 1 || n%2 == 0){
                p = head;
                head = head.next;
                continue;
            }

            tmp = f.next;
            f.next = head;
            p.next = head.next;
            head.next = tmp;
            f = head;
            head = p.next;
        }

        return h;
    }
}
