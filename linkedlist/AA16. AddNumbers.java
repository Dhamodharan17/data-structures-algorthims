//untill we have carry || list 1 || list 2
//create node for remainder and add carry and cumulative total
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int total = 0;
        int carry = 0;

       while(l1!=null || l2!=null || carry!=0){
        total = carry;

        if(l1!=null){
            total+=l1.val;
            l1=l1.next;
        }
        if(l2!=null){
            total+=l2.val;
            l2=l2.next;
        }
				//when value < 10 it is 0
        carry = total/10;
        int num = total%10;
        dummy.next = new ListNode(num);
        dummy = dummy.next;
       }

    return head.next;
    }
}

