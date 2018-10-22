package preminum.linklist;

import basements.ListNode;

public class CycleList {
    public boolean hasCycle(ListNode head) {
        ListNode stepOneNode = head;
        ListNode stepTwoNode = head;

        while (stepOneNode != null && stepTwoNode != null){
            stepTwoNode = stepTwoNode.next;
            if (stepTwoNode == null){
                break;
            }
            if (stepTwoNode == stepOneNode){
                return true;
            }
            stepOneNode = stepOneNode.next;
            stepTwoNode = stepTwoNode.next;
            if (stepTwoNode == stepOneNode){
                return true;
            }
        }
        return false;
    }
}
