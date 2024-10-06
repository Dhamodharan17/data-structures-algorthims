//Compare 1st and rev(2nd half)
//second half = slow.next
class Solution {
    public boolean isPalindrome(ListNode head) {

        
        //find mid
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse after mid
        ListNode head2 = rev(slow.next,null);

        while(head!=null && head2!=null){
            if(head.val!=head2.val) return false;
            head = head.next;
            head2=head2.next;
        }

        return true;
    
    }
    //reverse
    ListNode rev(ListNode head,ListNode prev){
        if(head == null) return prev;
        ListNode next =head.next;
        head.next=prev;
        return rev(next,head);//next and new prev i.e current

    }
}
