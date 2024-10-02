//AP1 - hashset which value comes again 1st
//AP2 - point all next to null , when cycle is there already null
//slow and fast pointer
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) break;
        }
        // when no cycle last node or no node
        if(fast==null || fast.next==null) return null;

        slow = head;
        while(fast!=slow){
            slow=slow.next;
            fast = fast.next;
        }

        return slow;

    }
}
