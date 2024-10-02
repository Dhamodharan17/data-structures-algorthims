public class Solution {
    public boolean hasCycle(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            //if loop, circle (imagine ground 2 people running p1 30km and p2 60 km - both will meet if circle)
            if(slow == fast) return true;
            fast = fast.next.next;
            slow = slow.next;
        }

    return false;

    }
}
