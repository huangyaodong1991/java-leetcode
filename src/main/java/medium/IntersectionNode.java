package medium;

import basements.ListNode;

/**
 *  相交链表
 *  编写一个程序，找到两个单链表相交的起始节点。
 *
 *
 *
 * 例如，下面的两个链表：
 *
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗
 * B:     b1 → b2 → b3
 * 在节点 c1 开始相交。
 *
 *
 *
 * 注意：
 *
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */
public class IntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListLengthAndTail listLengthAndTail = findListLengthAndTail(headA);
        ListLengthAndTail listLengthAndTail1 = findListLengthAndTail(headB);
        if (listLengthAndTail.tail != listLengthAndTail1.tail){
            return null;
        }

        ListNode pre, next;
        if (listLengthAndTail.length > listLengthAndTail1.length){
            pre = headA;
            next = headB;
        }else{
            pre = headB;
            next = headA;
        }

        int aheadSteps = Math.abs(listLengthAndTail.length - listLengthAndTail1.length);

        //长度长的先走
        for (int i = 0; i<aheadSteps; i++){
            pre = pre.next;
        }

        while (pre != null && next != null){
            if (pre == next){
                return pre;
            }

            pre = pre.next;
            next = next.next;
        }

        return null;
    }

    private ListLengthAndTail findListLengthAndTail(ListNode head){
        ListLengthAndTail result = new ListLengthAndTail();
        if (head == null){
            return result;
        }
        for (;head.next != null;head = head.next){
            result.length += 1;
        }
        result.length += 1;
        result.tail = head;
        return result;
    }

    private class ListLengthAndTail {
        int length = 0;
        ListNode tail = null;
    }
}
